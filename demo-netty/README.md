# NIO

传统IO流程：

![](../img/传统io内部流程.png)

NIO优化1：



![](../img/nio流程.png)

NIO优化2：linux2.1

![](../img/nio流程2.png)

NIO优化3：linux 2.4



![](../img/nio流程linux2.4.png)

# Netty

## 组件
### Channel
管道,对Socket的封装，简化Socket操作
### EventLoop

每个Channel都对应着一个EventLoop，用来处理用户连接请求、对用户请求处理等所有事件。它的本质是一个单线程执行器(同时维护了一个Selector)

EventLoop 本身只是一个线程驱动，在其生命周期内只会绑定一个线程，让该线程处理一个 Channel 的所有 IO 事件。

一个EventLoop可以对应多个Channel，一个Channel只能对应一个EventLoop

EventLoopGroup 是一组EventGroup，Channel一般会调用EventLoop的register方法来绑定其中一个EventLoop，后续这个Channel上的io事件都由此EventLoop来处理（保证IO线程安全）



![](../img/Eventloop.png)
### ServerBootStrap
用于配置整个 Netty 代码，将各个组件关联起来。服务端使用的是 ServerBootStrap，而客户端使用的是则 BootStrap。
###  Handler & Pipeline
ChannelHandler 是对 Channel 中数据的处理器，这些处理器可以是系统本身定义好的编解码器，也可以是用户自定义的。这些处理器会被统一添加到一个 ChannelPipeline 的对象中，然后按照添加的顺序对 Channel 中的数据进行依次处理。

- 入站处理器：ChannelInboundHandlerAdapter,读取客户端数据，写回结果
- 出站处理器：ChannelOutboundHandlerAdapter,对写回的结果加工

pipeline中默认有 head和tail两个handler，每次添加的handler都是在tail之前。

**pipeline中handler的执行顺序**：

入站是根据添加handler的顺序执行，出站是根据添加handler的顺序的方向执行。

 :heavy_exclamation_mark: ​入站:

```java
//传递数据到下一个handler
ctx.fireChannelRead(msg);
```

:rotating_light: 出站：

有多个出站处理器的时候，要在最后一个调用`ctx.writeAndFlush`，当调用这个方法的时候，会从当前handler往前找出站处理器.`ctx.channel().writeAndFlush` 会从tail开始找出站处理器进行处理。

![](../img/pipeline.png)



### Future & Promise
对异步操作进行回调，通过该对象的`addListener()`注册回调。

和异步方法配套使用，用来处理结果（建立连接、关闭连接 etc.）。处理结果的方法：

- 使用ChannelFuture.sync()同步处理结果 main 线程
- 使用ChannelFuture.addListener() 异步处理结果  nio 线程

```java
// 同步处理结果,主线程阻塞
channelFuture.sync();

//---------
// 异步处理
channelFuture.addListener(new ChannelFutureListener(){
    @Override
    // nio线程建立好连接之后，会调用该方法
    public void operationComplete(ChannelFuture future) throws Exception{
        future.channel();
        ....
    }
})
```

**异步提升了吞吐量（单位时间内处理请求的速度）**

**Netty的异步编程模型都是建立在 Future的概念之上的**

### ByteBuf

#### 直接内存 vs 堆内存

**直接内存**：分配效率低，读写效率高（少一次内存拷贝）系统内存映射到JAVA内存。配合池化一起 使用

**堆内存**：分配效率高，读写效率低

#### 池化 vs 非池化

池化最大意义就是可以复用 ByteBuf

- 高并发时，池化更解决内存，减少内存溢出的可能

通过环境变量设置池化是否开启：

`-Dio.netty.allocator.type={unpooled|pooled}`

- \>=4.1 ,非Android平台默认开启池化，Android启动非池化。
- < 4.1 ,默认非池化

#### 组成

![](../img/byteBuf组成.png)



#### 扩容

- 写入后数据大小未超过512，则选择下一个16的整数倍，例如写入后大小为12，则扩容capacity=16
- 写入后数据大小超过512，则选择下一个2^n，例如写入后大小为513，则扩容后capacity=2^10 = 1024（512=2^9)

创建byteBuf的时机：

AbstractNioByteChannel.java

```java
public final void read() {
            final ChannelConfig config = config();
            if (shouldBreakReadReady(config)) {
                clearReadPending();
                return;
            }
            final ChannelPipeline pipeline = pipeline();
            final ByteBufAllocator allocator = config.getAllocator();
            final RecvByteBufAllocator.Handle allocHandle = recvBufAllocHandle();
            allocHandle.reset(config);

            ByteBuf byteBuf = null;
            boolean close = false;
            try {
                do {
                    byteBuf = allocHandle.allocate(allocator);
                    allocHandle.lastBytesRead(doReadBytes(byteBuf));
                    if (allocHandle.lastBytesRead() <= 0) {
                        // nothing was read. release the buffer.
                        byteBuf.release();
                        byteBuf = null;
                        close = allocHandle.lastBytesRead() < 0;
                        if (close) {
                            // There is nothing left to read as we received an EOF.
                            readPending = false;
                        }
                        break;
                    }

                    allocHandle.incMessagesRead(1);
                    readPending = false;
                    pipeline.fireChannelRead(byteBuf);
                    byteBuf = null;
                } while (allocHandle.continueReading());

                allocHandle.readComplete();
                pipeline.fireChannelReadComplete();

                if (close) {
                    closeOnRead(pipeline);
                }
            } catch (Throwable t) {
                handleReadException(pipeline, byteBuf, t, close, allocHandle);
            } finally {
                // Check if there is a readPending which was not processed yet.
                // This could be for two reasons:
                // * The user called Channel.read() or ChannelHandlerContext.read() in channelRead(...) method
                // * The user called Channel.read() or ChannelHandlerContext.read() in channelReadComplete(...) method
                //
                // See https://github.com/netty/netty/issues/2254
                if (!readPending && !config.isAutoRead()) {
                    removeReadOp();
                }
            }
        }
    }
```

#### 内存回收

- UnpooledHeapByteBuf使用JVM内存，等到gc回收
- UnpooledDirectByteBuf 使用直接内存，调用方法来回收
- PooledBytebuf和其子类，更复杂的方法回收

#### 零拷贝

- slice

在切片的过程中，不会发生数据复制

- duplicate
- copy
- composite





## Netty执行流程
![](../img/netty流程.png)

## ChannelInboundHandlerAdapter和SimpleChannelInboundHandler

- SimpleChannelInboundHandler中的channelRead()方法会自动释放接收到的来自于对方的msg所占有的所有资源。

- ChannelInboundHandlerAdapter 中的 channelRead()方法不会自动释放接收到的来自于对方的msg

## 粘包与拆包

通过网络发送的一批二进制数据包，称为frame

- 当发送方的二进制数据包太大（太多），则会进行**拆包**被拆分成多个frame。接收方会进行**粘包**
- 当发送方的二进制数据包太小无法构成一个frame，则会将多个很小的数据包进行**粘包**合并成一个frame。接收方会进行**拆包**


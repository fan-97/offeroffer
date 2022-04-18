

## 组件
### Channel
管道,对Socket的封装，简化Socket操作
### EventLoop

每个Channel都对应着一个EventLoop，用来处理用户连接请求、对用户请求处理等所有事件。它的本质是一个单线程执行器(同时维护了一个Selector)

EventLoop 本身只是一个线程驱动，在其生命周期内只会绑定一个线程，让该线程处理一个 Channel 的所有 IO 事件。

一个EventLoop可以对应多个Channel，一个Channel只能对应一个EventLoop

EventLoopGroup 是一组EventGroup，Channel一般会调用EventLoop的register方法来绑定其中一个EventLoop，后续这个Channel上的io事件都由此EventLoop来处理（保证IO线程安全）

### ServerBootStrap
用于配置整个 Netty 代码，将各个组件关联起来。服务端使用的是 ServerBootStrap，而客户端使用的是则 BootStrap。
###  ChannelHandler 与 ChannelPipeline
ChannelHandler 是对 Channel 中数据的处理器，这些处理器可以是系统本身定义好的编解码器，也可以是用户自定义的。这些处理器会被统一添加到一个 ChannelPipeline 的对象中，然后按照添加的顺序对 Channel 中的数据进行依次处理。
### ChannelFuture
对异步操作进行回调，通过该对象的`addListener()`注册回调。

**Netty的异步编程模型都是建立在 Future的概念之上的**

## Netty执行流程
![](../img/netty流程.png)

## ChannelInboundHandlerAdapter和SimpleChannelInboundHandler

- SimpleChannelInboundHandler中的channelRead()方法会自动释放接收到的来自于对方的msg所占有的所有资源。

- ChannelInboundHandlerAdapter 中的 channelRead()方法不会自动释放接收到的来自于对方的msg

## 粘包与拆包

通过网络发送的一批二进制数据包，称为frame

- 当发送方的二进制数据包太大（太多），则会进行**拆包**被拆分成多个frame。接收方会进行**粘包**
- 当发送方的二进制数据包太小无法构成一个frame，则会将多个很小的数据包进行**粘包**合并成一个frame。接收方会进行**拆包**


package com.netty.demo.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author fanjie
 * @date 2020/6/20 11:21
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程组
        // 1.BossGroup 2.WorkerGroup  都是无限循环
        // BossGroup 处理连接请求
        // workerGroup 处理客户端的业务请求
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        // 创建服务器的启动对象，配置参数
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap
                // 设置线程组
                .group(bossGroup, workerGroup)
                // 设置channel实现
                .channel(NioServerSocketChannel.class)
                // 设置最大连接数为128
                .option(ChannelOption.SO_BACKLOG, 128)
                // 设置连接状态为长连接
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                // 设置接收buf大小
                .childOption(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(16, 16, 16))
                // 创建通道测试对象(匿名对象）
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    // 给pipeline 配置处理器
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                });

        //绑定一个端口并同步（启动服务器)
        ChannelFuture channelFuture = bootstrap.bind(6666).sync();
        System.out.println("server is already..");
        // 对关闭通道事件监听
        channelFuture.channel().closeFuture().sync();

    }
}

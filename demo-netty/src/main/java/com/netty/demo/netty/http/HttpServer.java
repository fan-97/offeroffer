package com.netty.demo.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author fanjie
 * @date 2020/6/20 17:30
 */
public class HttpServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossEventGroup = new NioEventLoopGroup();
        EventLoopGroup workerEventGroup = new NioEventLoopGroup();

        try {
            // 创建启动对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            // 配置启动参数
            serverBootstrap
                    .group(bossEventGroup,workerEventGroup)
                    .localAddress(8888)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HttpServerInitializer());

            System.out.println("server is run");
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();

        }finally {
            bossEventGroup.shutdownGracefully();
            workerEventGroup.shutdownGracefully();
        }
    }
}

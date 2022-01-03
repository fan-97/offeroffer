package com.netty.demo.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author fanjie
 * @date 2020/6/20 11:49
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {

            // 创建客户端启动对象
            Bootstrap bootstrap = new Bootstrap();

            // 配置启动参数
            bootstrap
                    .group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //添加客户端处理器
                            ch.pipeline().addLast(new NettyClientHandler());
                        }
                    });

            System.out.println("client already...");

            // 启动服务
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9999).sync();
            // 监听关闭通道
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventExecutors.shutdownGracefully();
        }
    }
}

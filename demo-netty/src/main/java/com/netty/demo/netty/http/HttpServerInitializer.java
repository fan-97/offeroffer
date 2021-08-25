package com.netty.demo.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author fanjie
 * @date 2020/6/20 17:35
 */
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // 向管道加入处理器
        ChannelPipeline pipeline = ch.pipeline();
        // 对HTTP内容进行编码和解码
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());
        // 加入Server的处理器
        pipeline.addLast("MyHttpServerHandler",new HttpServerHandler());
    }
}

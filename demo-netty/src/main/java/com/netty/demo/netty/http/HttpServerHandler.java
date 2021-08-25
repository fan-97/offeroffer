package com.netty.demo.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @author fanjie
 * @date 2020/6/20 17:35
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        // 判断msg是否是HttpRequest请求
        if (msg instanceof HttpRequest) {
            System.out.println("msg 类型："+msg.getClass());
            System.out.println("客户端地址："+ctx.channel().remoteAddress());

            // 给浏览器响应信息
            ByteBuf buf = Unpooled.copiedBuffer("服务器响应信息", CharsetUtil.UTF_8);

            // 构造http响应体
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, buf);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain;charset=utf-8");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,buf.readableBytes());

            // 返回给浏览器
            ctx.writeAndFlush(response);

        }
    }
}

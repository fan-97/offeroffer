package com.netty.demo.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author fanjie
 * @date 2020/6/20 11:56
 */
public class NettyClientHandler extends SimpleChannelInboundHandler {

    // 管道就绪触发该方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client ctx = " + ctx);
        for (int i = 0; i < 2; i++) {
//            ctx.channel().writeAndFlush()
            ctx.channel().writeAndFlush(Unpooled.copiedBuffer("hello server:" + i, CharsetUtil.UTF_8));
        }

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("服务器回复的消息：" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("服务器的地址:" + ctx.channel().remoteAddress());
//        ctx.channel().writeAndFlush(Unpooled.copiedBuffer("hello server: " + ChannelInboundHandlerAdapter.class, CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

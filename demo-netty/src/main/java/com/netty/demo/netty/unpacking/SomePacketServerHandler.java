package com.netty.demo.netty.unpacking;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author fanjie
 * @date 2022/4/12 10:40
 */
public class SomePacketServerHandler extends SimpleChannelInboundHandler<String> {
    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("server 收到第【" + ++count + "个数据包:" + msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

package com.netty.demo.netty.unpacking;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author fanjie
 * @date 2022/4/12 10:27
 */
public class SomePacketClientHandler extends ChannelInboundHandlerAdapter {
    private String message = "Netty is a NIO client server framework " +
            "which enables quick and easy development of network applications " +
            "such as protocol servers and clients. It greatly simplifies and " +
            "streamlines network programming such as TCP and UDP socket server." +
            "'Quick and easy' doesn't mean that a resulting application will " +
            "suffer from a maintainability or a performance issue. Netty has " +
            "this guide and play with Netty.In other words, Netty is an NIO " +
            "framework that enables quick and easy development of network " +
            "as protocol servers and clients. It greatly simplifies and network " +
            "programming such as TCP and UDP socket server development.'Quick " +
            "not mean that a resulting application will suffer from a maintain" +
            "performance issue. Netty has been designed carefully with the expe " +
            "from the implementation of a lot of protocols such as FTP, SMTP, " +
            " binary and text-based legacy protocols. As a result, Netty has " +
            "a way to achieve of development, performance, stability, without " +
            "which enables quick and easy development of network applications " +
            "such as protocol servers and clients. It greatly simplifies and " +
            "streamlines network programming such as TCP and UDP socket server." +
            "'Quick and easy' doesn't mean that a resulting application will " +
            "suffer from a maintainability or a performance issue. Netty has " +
            "this guide and play with Netty.In other words, Netty is an NIO " +
            "framework that enables quick and easy development of network " +
            "as protocol servers and clients. It greatly simplifies and network " +
            "programming such as TCP and UDP socket server development.'Quick " +
            "not mean that a resulting application will suffer from a maintain" +
            "performance issue. Netty has been designed carefully with the expe " +
            "from the implementation of a lot of protocols such as FTP, SMTP, " +
            " binary and text-based legacy protocols. As a result, Netty has " +
            "a way to achieve of development, performance, stability, without " +
            "which enables quick and easy development of network applications " +
            "such as protocol servers and clients. It greatly simplifies and " +
            "streamlines network programming such as TCP and UDP socket server." +
            "'Quick and easy' doesn't mean that a resulting application will " +
            "suffer from a maintainability or a performance issue. Netty has " +
            "this guide and play with Netty.In other words, Netty is an NIO " +
            "framework that enables quick and easy development of network " +
            "as protocol servers and clients. It greatly simplifies and network " +
            "programming such as TCP and UDP socket server development.'Quick " +
            "not mean that a resulting application will suffer from a maintain" +
            "performance issue. Netty has been designed carefully with the expe " +
            "from the implementation of a lot of protocols such as FTP, SMTP, " +
            " binary and text-based legacy protocols. As a result, Netty has " +
            "a way to achieve of development, performance, stability, without " +
            "which enables quick and easy development of network applications " +
            "such as protocol servers and clients. It greatly simplifies and " +
            "framework that enables quick and easy development of network " +
            "as protocol servers and clients. It greatly simplifies and network " +
            "programming such as TCP and UDP socket server development.'Quick " +
            "not mean that a resulting application will suffer from a maintain" +
            "performance issue. Netty has been designed carefully with the expe " +
            "from the implementation of a lot of protocols such as FTP, SMTP, " +
            " binary and text-based legacy protocols. As a result, Netty has " +
            "a way to achieve of development, performance, stability, without " +
            "which enables quick and easy development of network applications " +
            "such as protocol servers and clients. It greatly simplifies and " +
            "framework that enables quick and easy development of network " +
            "as protocol servers and clients. It greatly simplifies and network " +
            "programming such as TCP and UDP socket server development.'Quick " +
            "not mean that a resulting application will suffer from a maintain" +
            "performance issue. Netty has been designed carefully with the expe " +
            "from the implementation of a lot of protocols such as FTP, SMTP, " +
            " binary and text-based legacy protocols. As a result, Netty has " +
            "a way to achieve of development, performance, stability, without " +
            "which enables quick and easy development of network applications " +
            "such as protocol servers and clients. It greatly simplifies and " +
            "streamlines network programming such as TCP and UDP socket server." +
            "'Quick and easy' doesn't mean that a resulting application will " +
            "suffer from a maintainability or a performance issue. Netty has " +
            "this guide and play with Netty.In other words, Netty is an NIO " +
            "framework that enables quick and easy development of network " +
            "as protocol servers and clients. It greatly simplifies and network " +
            "programming such as TCP and UDP socket server development.'Quick " +
            "not mean that a resulting application will suffer from a maintain" +
            "performance issue. Netty has been designed carefully with the expe " +
            "from the implementation of a lot of protocols such as FTP, SMTP, " +
            " binary and text-based legacy protocols. As a result, Netty has " +
            "a way to achieve of development, performance, stability, without " +
            "a compromise.=====================================================";

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.write(message);
        ctx.writeAndFlush("hello==============");
//        ctx.writeAndFlush(message);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause);
        ctx.close();
    }
}

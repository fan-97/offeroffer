package com.netty.demo.netty.core;

import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.local.LocalServerChannel;

/**
 * @author fanjie
 * @date 2020/6/26 15:37
 */
public class ChannelDemo1 {
    public static void main(String[] args) {
        EmbeddedChannel embeddedChannel = new EmbeddedChannel();
        LocalServerChannel localServerChannel = new LocalServerChannel();
    }
}

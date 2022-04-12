/**
 * 发送方粘包
 * 客户端作为发送方，向服务端发送 100 个小的 ByteBuf 数据包，这 100 个数据包会被合
 * 并为若干个 Frame 进行发送。这个过程中会发生粘包与拆包。
 * 服务端作为接收方，直接将接收到的 Frame 解码为 String 后进行显示，不对这些 Frame
 * 进行粘包与拆包。
 * @author fanjie
 * @date 2022/4/12 11:47
 */
package com.netty.demo.netty.stickybag;

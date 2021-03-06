
/**
 * 发送方拆包
 * 客户端作为发送方，向服务端发送两个大的 ByteBuf 数据包，这两个数据包会被拆分为
 * 若干个 Frame 进行发送。这个过程中会发生拆包与粘包。
 * 服务端作为接收方，直接将接收到的 Frame 解码为 String 后进行显示，不对这些 Frame
 * 进行粘包与拆包。
 * @author fanjie
 * @date 2022/4/12 10:26
 */
package com.netty.demo.netty.unpacking;

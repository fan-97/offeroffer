package com.netty.demo.netty.rpc.server.server;

import com.netty.demo.netty.rpc.api.dto.Invocation;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;

// ChannelInboundHandlerAdapter：不会自动释放msg
// SimpleChannelInboundHandler：会自动释放msg
public class RpcServerHandler extends SimpleChannelInboundHandler<Invocation> {

    private Map<String, Object> registerMap;

    public RpcServerHandler(Map<String, Object> registerMap) {
        this.registerMap = registerMap;
    }

    // 解析Client发送来的msg，然后从registerMap注册表中查看是否有对应的接口
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Invocation msg) throws Exception {
        Object result = "没有该提供者，或没有该方法";
        if (registerMap.containsKey(msg.getClassName())) {
            // 从注册表中获取接口对应的实现类实例
            Object invoker = registerMap.get(msg.getClassName());
            result = invoker.getClass().getMethod(msg.getMethodName(), msg.getParamTypes())
                    .invoke(invoker, msg.getParamValues());
        }
        // 将运算结果返回给client
        ctx.writeAndFlush(result);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

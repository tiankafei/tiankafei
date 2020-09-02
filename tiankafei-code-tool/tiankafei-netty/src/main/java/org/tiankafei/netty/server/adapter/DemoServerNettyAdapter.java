package org.tiankafei.netty.server.adapter;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author 甜咖啡
 */
public class DemoServerNettyAdapter extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        String message = new String(bytes, "UTF-8");
        System.out.println("收到消息：" + message);

        //向客户端写数据
        String returnMessage = "收到了你的消息，你的消息是:" + message;
        ByteBuf buffer = Unpooled.copiedBuffer(returnMessage.getBytes());
        //写入缓冲数组
        ctx.write(buffer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务端收到消息完成=channelReadComplete...");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("收到一个客户端的断开连接提示=cexceptionCaught...");
    }

}

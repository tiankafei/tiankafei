package org.tiankafei.netty.client.adapter;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import java.io.UnsupportedEncodingException;

/**
 * @author 甜咖啡
 */
public class DemoClientNettyAdapter extends ChannelHandlerAdapter {

    protected String message;

    public DemoClientNettyAdapter() {
        message = "发条消息玩玩";
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("发送消息：" + message);
        byte[] bytes = message.getBytes();
        ByteBuf byteBuf = Unpooled.buffer(bytes.length);
        //写入buffer
        byteBuf.writeBytes(bytes);
        //向服务端发送数据
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            //读取服务端发过来的数据
            ByteBuf buf = (ByteBuf) msg;
            byte[] bytes = new byte[buf.readableBytes()];
            buf.readBytes(bytes);
            String message = new String(bytes, "UTF-8");
            System.out.println("收到消息：" + message);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端收到消息完成=channelReadComplete...");
        ctx.flush();
    }

}

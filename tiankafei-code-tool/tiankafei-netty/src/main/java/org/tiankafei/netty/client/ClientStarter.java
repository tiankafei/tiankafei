package org.tiankafei.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.tiankafei.netty.client.adapter.DemoClientNettyAdapter;
import org.tiankafei.netty.common.NettyConstants;

/**
 * @author 甜咖啡
 */
public class ClientStarter {

    public static void main(String[] args) {
        ClientStarter.initClient(NettyConstants.DEFAULT_SERVER, NettyConstants.DEFAULT_PORT);
    }

    public static void initClient(String serverIp, int serverPort) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DemoClientNettyAdapter());
                        }
                    });
            ChannelFuture future = bootstrap.connect(serverIp, serverPort).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

}

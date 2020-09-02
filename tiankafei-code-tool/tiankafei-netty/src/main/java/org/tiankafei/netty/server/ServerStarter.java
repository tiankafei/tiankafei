package org.tiankafei.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.tiankafei.base.util.LogUtil;
import org.tiankafei.netty.common.NettyConstants;
import org.tiankafei.netty.server.adapter.DemoServerNettyAdapter;

/**
 * @author 甜咖啡
 */
public class ServerStarter {

    public static void main(String[] args) {
        ServerStarter.bind(NettyConstants.DEFAULT_PORT);
    }

    private static void bind(int port) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ChannelFuture future = null;
        try {
            //服务端辅助启动类，用以降低服务端的开发复杂度
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    //实例化ServerSocketChannel
                    .channel(NioServerSocketChannel.class)
                    //设置ServerSocketChannel的TCP参数
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DemoServerNettyAdapter());
                        }
                    });
            // ChannelFuture：代表异步I/O的结果
            String serverIp = NettyConstants.DEFAULT_SERVER;
            LogUtil.info("服务端启动ip=" + serverIp);
            ChannelFuture f = bootstrap.bind(serverIp, port).sync();
            future = f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("启动netty服务异常");
        } finally {
            // 安全关闭逻辑
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            try {
                // 关闭连接
                future.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

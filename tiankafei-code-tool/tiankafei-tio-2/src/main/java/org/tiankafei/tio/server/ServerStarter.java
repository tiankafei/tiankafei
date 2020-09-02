package org.tiankafei.tio.server;

import java.io.IOException;
import org.tiankafei.tio.common.TioConstants;
import org.tiankafei.tio.server.handler.DemoServerAioHandler;
import org.tiankafei.tio.server.listener.DemoServerAioListener;
import org.tiankafei.ui.design.modelsui.TkfTextArea;
import org.tio.server.AioServer;
import org.tio.server.ServerGroupContext;
import org.tio.server.intf.ServerAioHandler;
import org.tio.server.intf.ServerAioListener;

/**
 * 服务端启动类
 *
 * @author 甜咖啡
 */
public class ServerStarter {

    public static void main(String[] args) throws IOException {
        String serverIp = TioConstants.DEFAULT_SERVER;
        int serverPort = TioConstants.DEFAULT_PORT;
        ServerStarter.serverStart(serverIp, serverPort);
    }

    /**
     * 启动服务端
     *
     * @param serverIp   服务器ip
     * @param serverPort 服务器端口
     */
    public static void serverStart(String serverIp, int serverPort) {
        serverStart(serverIp, serverPort, null);
    }

    /**
     * 启动服务端
     *
     * @param serverIp    服务器ip
     * @param serverPort  服务器端口
     * @param tkfTextArea 文本域
     */
    public static void serverStart(String serverIp, int serverPort, TkfTextArea tkfTextArea) {
        try {
            //服务端处理类
            ServerAioHandler serverAioHandler = new DemoServerAioHandler(tkfTextArea);
            //服务端监听类
            ServerAioListener serverAioListener = new DemoServerAioListener();

            //创建服务端分组上下文对象
            ServerGroupContext serverGroupContext = new ServerGroupContext(serverAioHandler, serverAioListener);
            //设置心跳超时时间
            serverGroupContext.setHeartbeatTimeout(TioConstants.SERVER_TIMEOUT);
            //本机启动服务
            AioServer aioServer = new AioServer(serverGroupContext);
            aioServer.start(serverIp, serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

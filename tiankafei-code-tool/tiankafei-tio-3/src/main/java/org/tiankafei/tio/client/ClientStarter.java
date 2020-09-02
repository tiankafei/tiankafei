package org.tiankafei.tio.client;

import com.google.common.collect.Lists;
import java.util.List;
import org.tiankafei.tio.client.handler.DemoClientAioHandler;
import org.tiankafei.tio.client.listener.DemoClientAioListener;
import org.tiankafei.tio.common.TioConstants;
import org.tiankafei.tio.common.TioPacketBuilder;
import org.tiankafei.tio.common.TioPacketType;
import org.tiankafei.tio.dto.TioPacketDTO;
import org.tiankafei.tio.util.TioUtil;
import org.tiankafei.ui.design.modelsui.TkfTextArea;
import org.tio.client.ClientChannelContext;
import org.tio.client.ClientGroupContext;
import org.tio.client.ReconnConf;
import org.tio.client.TioClient;
import org.tio.client.intf.ClientAioHandler;
import org.tio.client.intf.ClientAioListener;
import org.tio.core.ChannelContext;
import org.tio.core.Node;
import org.tio.core.Tio;

/**
 * 客户端启动类
 *
 * @author 甜咖啡
 */
public class ClientStarter {

    /**
     * 断链后自动连接的，不想自动连接请设为null
     */
    private static ReconnConf reconnConf = new ReconnConf(5000L);

    /**
     * 客户端分组上下文对象
     */
    private ClientGroupContext clientGroupContext;

    /**
     * 分组名称
     */
    private String groupName;

    public static void main(String[] args) {
        ClientStarter clientStarter = new ClientStarter();
        String serverIp = TioConstants.DEFAULT_SERVER;
        int serverPort = TioConstants.DEFAULT_PORT;
        List<Node> nodeList = Lists.newArrayList();
        for (int portIndex = 0, portLength = 10; portIndex < portLength; portIndex++) {
            Node node = new Node(serverIp, serverPort);
            nodeList.add(node);
        }
        clientStarter.initClientTio(nodeList);
        //连上后，发条消息玩玩
        clientStarter.sendGroup("发条消息玩玩");
    }

    /**
     * 初始化客户端tio
     *
     * @param nodeList 服务端列表
     */
    public void initClientTio(List<Node> nodeList) {
        initClientTio(TioConstants.DEFAULT_GROUP_NAME, nodeList);
    }

    /**
     * 初始化客户端tio
     *
     * @param groupName 分组名称
     * @param nodeList  服务端列表
     */
    public void initClientTio(String groupName, List<Node> nodeList) {
        initClientTio(groupName, nodeList, null);
    }

    /**
     * 初始化客户端tio
     *
     * @param nodeList    服务端列表
     * @param tkfTextArea 消息输出控件
     */
    public void initClientTio(List<Node> nodeList, TkfTextArea tkfTextArea) {
        initClientTio(TioConstants.DEFAULT_GROUP_NAME, nodeList, tkfTextArea);
    }

    /**
     * 初始化客户端tio
     *
     * @param groupName   分组名称
     * @param nodeList    服务端列表
     * @param tkfTextArea 消息输出控件
     */
    public void initClientTio(String groupName, List<Node> nodeList, TkfTextArea tkfTextArea) {
        this.groupName = groupName;
        //客户端处理类
        ClientAioHandler tioClientHandler = new DemoClientAioHandler(tkfTextArea);
        //客户端监听类
        ClientAioListener clientAioListener = new DemoClientAioListener();

        //创建客户端分组上下文对象
        clientGroupContext = new ClientGroupContext(tioClientHandler, clientAioListener, reconnConf);
        //设置心跳超时时间
        clientGroupContext.setHeartbeatTimeout(TioConstants.CLIENT_TIMEOUT);
        //启动服务
        for (int nodeIndex = 0, nodeLength = nodeList.size(); nodeIndex < nodeLength; nodeIndex++) {
            try {
                TioClient tioClient = new TioClient(clientGroupContext);
                Node serverNode = nodeList.get(nodeIndex);
                ClientChannelContext clientChannelContext = tioClient.connect(serverNode);
                //加入分组
                Tio.bindGroup(clientChannelContext, groupName);
                Tio.bindUser(clientChannelContext, TioUtil.getUserId(serverNode));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 客户端向分组发送消息
     *
     * @param message 要发送的消息
     */
    public void sendGroup(String message) {
        TioPacketDTO tioPacketDTO = new TioPacketBuilder<>().setType(TioPacketType.SEND_MESSAGE).setBody(message).build();
        Tio.sendToGroup(clientGroupContext, groupName, tioPacketDTO);
    }

    /**
     * 客户端向单个节点发送消息
     *
     * @param channelContext 要发送消息的节点
     * @param message        要发送的消息
     */
    public void send(ChannelContext channelContext, String message) {
        TioPacketDTO tioPacketDTO = new TioPacketBuilder<>().setType(TioPacketType.SEND_MESSAGE).setBody(message).build();
        System.out.println("发送消息包=" + tioPacketDTO.hashCode());
        Tio.send(channelContext, tioPacketDTO);
    }

    /**
     * 客户端向单个节点发送消息（阻塞）
     *
     * @param channelContext 要发送消息的节点
     * @param message        要发送的消息
     */
    public void bsend(ChannelContext channelContext, String message) {
        TioPacketDTO tioPacketDTO = new TioPacketBuilder<>().setType(TioPacketType.SEND_MESSAGE).setBody(message).build();
        Tio.bSend(channelContext, tioPacketDTO);
    }

    /**
     * 客户端向单个节点发送消息（阻塞）
     *
     * @param userId  要发送用户id（该id绑定的节点）
     * @param message 要发送的消息
     */
    public void sendUser(String userId, String message) {
        TioPacketDTO tioPacketDTO = new TioPacketBuilder<>().setType(TioPacketType.SEND_MESSAGE).setBody(message).build();
        Tio.sendToUser(clientGroupContext, userId, tioPacketDTO);
    }

    public ClientGroupContext getClientGroupContext() {
        return clientGroupContext;
    }
}

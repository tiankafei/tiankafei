package org.tiankafei.tio.event;

import org.springframework.context.ApplicationEvent;
import org.tiankafei.tio.dto.TioPacketDTO;
import org.tio.client.ClientChannelContext;
import org.tio.core.GroupContext;

/**
 * @author 甜咖啡
 */
public class TioEvent extends ApplicationEvent {

    /**
     * 要发送消息的包
     */
    private TioPacketDTO tioPacketDTO;

    /**
     * 用户连接管道
     */
    private ClientChannelContext clientChannelContext;

    /**
     * 发送消息标识（可能是分组名称、用户id、用户连接管道id、ip）
     */
    private String mark;

    /**
     * 消息分组
     */
    private GroupContext groupContext;

    /**
     * 单发消息
     *
     * @param source               源对象
     * @param tioPacketDTO         tio传输数据包
     * @param clientChannelContext 客户端连接对象
     */
    public TioEvent(Object source, TioPacketDTO tioPacketDTO, ClientChannelContext clientChannelContext) {
        super(source);
        this.tioPacketDTO = tioPacketDTO;
        this.clientChannelContext = clientChannelContext;
    }

    /**
     * 群发消息
     *
     * @param source       源对象
     * @param groupContext 群分组
     * @param mark         唯一标示
     * @param tioPacketDTO tio传输数据包
     */
    public TioEvent(Object source, GroupContext groupContext, String mark, TioPacketDTO tioPacketDTO) {
        super(source);
        this.groupContext = groupContext;
        this.mark = mark;
        this.tioPacketDTO = tioPacketDTO;
    }

    public TioPacketDTO getTioPacketDTO() {
        return tioPacketDTO;
    }

    public ClientChannelContext getClientChannelContext() {
        return clientChannelContext;
    }
}

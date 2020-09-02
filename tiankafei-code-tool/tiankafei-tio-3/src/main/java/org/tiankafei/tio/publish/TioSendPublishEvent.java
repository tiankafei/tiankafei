package org.tiankafei.tio.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.tiankafei.tio.dto.TioPacketDTO;
import org.tiankafei.tio.event.TioEvent;
import org.tio.client.ClientChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.Tio;

/**
 * @author 甜咖啡
 */
@Component
public class TioSendPublishEvent {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 指定用户连接管道单发消息
     *
     * @param tioPacketDTO         tio传输数据包
     * @param clientChannelContext 客户端连接对象
     */
    public void send(TioPacketDTO tioPacketDTO, ClientChannelContext clientChannelContext) {
        applicationContext.publishEvent(new TioEvent(this, tioPacketDTO, clientChannelContext));
        Tio.send(clientChannelContext, tioPacketDTO);
    }

    /**
     * 指定用户id单发消息
     *
     * @param groupContext 群分组列表
     * @param userid       用户ID
     * @param tioPacketDTO tio传输数据包
     */
    public void sendToUser(GroupContext groupContext, String userid, TioPacketDTO tioPacketDTO) {
        applicationContext.publishEvent(new TioEvent(this, groupContext, userid, tioPacketDTO));
        Tio.sendToUser(groupContext, userid, tioPacketDTO);
    }

    /**
     * 指定用户连接管道id单发消息
     *
     * @param groupContext 群分组列表
     * @param channelId    客户端连接id
     * @param tioPacketDTO tio传输数据包
     */
    public void sendToId(GroupContext groupContext, String channelId, TioPacketDTO tioPacketDTO) {
        applicationContext.publishEvent(new TioEvent(this, groupContext, channelId, tioPacketDTO));
        Tio.sendToId(groupContext, channelId, tioPacketDTO);
    }

    /**
     * 指定ip单发消息
     *
     * @param groupContext 群分组列表
     * @param ip           ip端口
     * @param tioPacketDTO tio传输数据包
     */
    public void sendToIp(GroupContext groupContext, String ip, TioPacketDTO tioPacketDTO) {
        applicationContext.publishEvent(new TioEvent(this, groupContext, ip, tioPacketDTO));
        Tio.sendToIp(groupContext, ip, tioPacketDTO);
    }

    /**
     * 指定分组名称群发消息
     *
     * @param groupContext 群分组列表
     * @param groupName    分组名称
     * @param tioPacketDTO tio传输数据包
     */
    public void sendToGroup(GroupContext groupContext, String groupName, TioPacketDTO tioPacketDTO) {
        applicationContext.publishEvent(new TioEvent(this, groupContext, groupName, tioPacketDTO));
        Tio.sendToGroup(groupContext, groupName, tioPacketDTO);
    }

}

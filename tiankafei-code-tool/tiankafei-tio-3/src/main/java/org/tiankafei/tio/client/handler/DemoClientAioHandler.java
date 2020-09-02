package org.tiankafei.tio.client.handler;

import org.apache.commons.lang3.ArrayUtils;
import org.tiankafei.tio.common.TioConstants;
import org.tiankafei.tio.common.handler.BaseAioHandler;
import org.tiankafei.tio.dto.TioPacketDTO;
import org.tiankafei.ui.design.modelsui.TkfTextArea;
import org.tio.client.intf.ClientAioHandler;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.utils.json.Json;

/**
 * @author 甜咖啡
 */
public class DemoClientAioHandler extends BaseAioHandler implements ClientAioHandler {

    private static TioPacketDTO heartbeatTioPacketDTO = new TioPacketDTO();

    private TkfTextArea tkfTextArea;

    public DemoClientAioHandler() {

    }

    public DemoClientAioHandler(TkfTextArea tkfTextArea) {
        this.tkfTextArea = tkfTextArea;
    }

    /**
     * 处理消息
     */
    @Override
    public void handler(Packet packet, ChannelContext channelContext) throws Exception {
        TioPacketDTO tioPacketDTO = (TioPacketDTO) packet;
        byte[] body = ArrayUtils.toPrimitive(tioPacketDTO.getBody());
        if (body != null) {
            String message = Json.toBean(new String(body, TioConstants.PACKET_CHARSET), String.class);
            System.out.println("收到消息：" + message);
            System.out.println("消息包=" + tioPacketDTO.hashCode());
            System.out.println("MessageType" + tioPacketDTO.getType());
            if (tkfTextArea != null) {
                tkfTextArea.append("收到消息：" + message + "\n");
            }
        }
        return;
    }

    /**
     * 此方法如果返回null，框架层面则不会发心跳；如果返回非null，框架层面会定时发本方法返回的消息包
     */
    @Override
    public TioPacketDTO heartbeatPacket() {
        return heartbeatTioPacketDTO;
    }
}

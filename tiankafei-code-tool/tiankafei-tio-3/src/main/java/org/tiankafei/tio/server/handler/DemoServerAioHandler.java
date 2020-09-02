package org.tiankafei.tio.server.handler;

import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.tiankafei.tio.common.TioConstants;
import org.tiankafei.tio.common.TioPacketBuilder;
import org.tiankafei.tio.common.TioPacketType;
import org.tiankafei.tio.common.handler.BaseAioHandler;
import org.tiankafei.tio.dto.TioPacketDTO;
import org.tiankafei.ui.design.modelsui.TkfTextArea;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.core.intf.Packet;
import org.tio.server.intf.ServerAioHandler;
import org.tio.utils.json.Json;

/**
 * @author 甜咖啡
 */
public class DemoServerAioHandler extends BaseAioHandler implements ServerAioHandler {

    private TkfTextArea tkfTextArea;

    public DemoServerAioHandler() {

    }

    public DemoServerAioHandler(TkfTextArea tkfTextArea) {
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
            System.out.println("消息包=" + tioPacketDTO.hashCode());
            System.out.println("MessageType" + tioPacketDTO.getType());

            DemoServerHandleThread demoServerHandleThread = new DemoServerHandleThread(channelContext, message);
            demoServerHandleThread.start();
        }
        return;
    }

    class DemoServerHandleThread extends Thread {
        private ChannelContext channelContext;
        private String str;

        public DemoServerHandleThread(ChannelContext channelContext, String str) {
            this.channelContext = channelContext;
            this.str = str;
        }

        @Override
        public void run() {
            try {
                Random random = new Random();
                int location = random.nextInt(6);
                int time = location * 1000;
                System.out.println("休眠的时间为=" + time);
                Thread.sleep(time);

                System.out.println("收到消息：" + str);
                if (tkfTextArea != null) {
                    tkfTextArea.append("收到消息：" + str + "=====执行的时间为=" + time + "\n");
                }

                String message = "收到了你的消息，你的消息是:" + str;
                TioPacketDTO tioPacketDTO = new TioPacketBuilder<>().setType(TioPacketType.SEND_MESSAGE).setBody(message).build();
                Tio.send(channelContext, tioPacketDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

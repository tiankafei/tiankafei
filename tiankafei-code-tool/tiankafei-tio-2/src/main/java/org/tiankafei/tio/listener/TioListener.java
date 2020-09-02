package org.tiankafei.tio.listener;

import org.springframework.context.ApplicationListener;
import org.tiankafei.tio.dto.TioPacketDTO;
import org.tiankafei.tio.event.TioEvent;
import org.tio.client.ClientChannelContext;

/**
 * @author 甜咖啡
 */
public class TioListener implements ApplicationListener<TioEvent> {

    @Override
    public void onApplicationEvent(TioEvent event) {
        TioPacketDTO tioPacketDTO = event.getTioPacketDTO();
        ClientChannelContext clientChannelContext = event.getClientChannelContext();

        System.out.println(tioPacketDTO);
        System.out.println(clientChannelContext);
    }

}

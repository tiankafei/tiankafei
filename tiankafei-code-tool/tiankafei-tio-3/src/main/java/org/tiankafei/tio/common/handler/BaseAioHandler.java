package org.tiankafei.tio.common.handler;

import java.nio.ByteBuffer;
import org.apache.commons.lang3.ArrayUtils;
import org.tiankafei.tio.common.TioConstants;
import org.tiankafei.tio.dto.TioPacketDTO;
import org.tio.core.ChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.exception.AioDecodeException;
import org.tio.core.intf.AioHandler;
import org.tio.core.intf.Packet;

/**
 * @author 甜咖啡
 */
public abstract class BaseAioHandler implements AioHandler {

    @Override
    public Packet decode(ByteBuffer buffer, int limit, int position, int readableLength, ChannelContext channelContext) throws AioDecodeException {
        //收到的数据组不了业务包，则返回null以告诉框架数据不够
        if (readableLength < TioConstants.PACKET_HEADER_LENGHT) {
            return null;
        }

        //读取消息体的长度
        int bodyLength = buffer.getInt();

        //数据不正确，则抛出AioDecodeException异常
        if (bodyLength < 0) {
            throw new AioDecodeException("bodyLength [" + bodyLength + "] is not right, remote:" + channelContext.getClientNode());
        }

        //计算本次需要的数据长度
        int neededLength = TioConstants.PACKET_HEADER_LENGHT + bodyLength;
        //收到的数据是否足够组包
        int isDataEnough = readableLength - neededLength;
        // 不够消息体长度(剩下的buffe组不了消息体)
        if (isDataEnough < 0) {
            return null;
        } else //组包成功
        {
            TioPacketDTO tioPacketDTO = new TioPacketDTO();
            if (bodyLength > 0) {
                byte[] dst = new byte[bodyLength];
                buffer.get(dst);
                tioPacketDTO.setBody(ArrayUtils.toObject(dst));
            }
            return tioPacketDTO;
        }
    }

    @Override
    public ByteBuffer encode(Packet packet, GroupContext groupContext, ChannelContext channelContext) {
        TioPacketDTO tioPacketDTO = (TioPacketDTO) packet;
        byte[] body = ArrayUtils.toPrimitive(tioPacketDTO.getBody());
        int bodyLen = 0;
        if (body != null) {
            bodyLen = body.length;
        }

        //bytebuffer的总长度是 = 消息头的长度 + 消息体的长度
        int allLen = TioConstants.PACKET_HEADER_LENGHT + bodyLen;
        //创建一个新的bytebuffer
        ByteBuffer buffer = ByteBuffer.allocate(allLen);
        //设置字节序
        buffer.order(groupContext.getByteOrder());

        //写入消息头----消息头的内容就是消息体的长度
        buffer.putInt(bodyLen);

        //写入消息体
        if (body != null) {
            buffer.put(body);
        }
        return buffer;
    }

}

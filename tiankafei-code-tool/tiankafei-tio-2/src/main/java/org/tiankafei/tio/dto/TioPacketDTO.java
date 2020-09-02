package org.tiankafei.tio.dto;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import org.tiankafei.tio.common.TioConstants;
import org.tio.core.intf.Packet;

/**
 * @author 甜咖啡
 */
public class TioPacketDTO extends Packet {

    private static final long serialVersionUID = 5781763570525732145L;

    /**
     * 消息类型，其值在Type中定义
     */
    private Byte type;

    private Byte[] body;

    public TioPacketDTO() {

    }

    public TioPacketDTO(Byte type, Byte[] body) {
        this.type = type;
        this.body = body;
    }

    public TioPacketDTO(Byte type, String body) {
        this.type = type;
        setBody(body);
    }

    public void setBody(String body) {
        try {
            this.body = ArrayUtils.toObject(body.getBytes(TioConstants.PACKET_CHARSET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getType() {
        return type;
    }

    public Byte[] getBody() {
        return body;
    }

    public void setBody(Byte[] body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "TioPacketDTO{" +
                "type=" + type +
                ", body=" + Arrays.toString(body) +
                '}';
    }
}

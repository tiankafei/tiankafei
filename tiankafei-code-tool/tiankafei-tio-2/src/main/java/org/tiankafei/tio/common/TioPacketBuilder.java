package org.tiankafei.tio.common;

import org.tiankafei.tio.dto.TioPacketDTO;
import org.tio.utils.json.Json;

/**
 * @author 甜咖啡
 */
public class TioPacketBuilder<T> {

    /**
     * 消息类型，其值在Type中定义
     */
    private byte type;

    /**
     * 消息体
     */
    private T body;

    public TioPacketBuilder<T> setType(byte type) {
        this.type = type;
        return this;
    }

    public TioPacketBuilder<T> setBody(T body) {
        this.body = body;
        return this;
    }

    public TioPacketDTO build() {
        return new TioPacketDTO(type, Json.toJson(body));
    }

}

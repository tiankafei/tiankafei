package org.tiankafei.web.common.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
public class DeviceInfo implements Serializable {

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备型号
     */
    private String model;

}

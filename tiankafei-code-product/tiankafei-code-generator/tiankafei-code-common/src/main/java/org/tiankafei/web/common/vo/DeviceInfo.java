package org.tiankafei.web.common.vo;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

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

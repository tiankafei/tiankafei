package org.tiankafei.ui.control.datetime;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 时间控件对象
 *
 * @author tiankafei1
 */
@Data
@Accessors(chain = true)
public class DataTimeControlsDTO {

    /**
     * 年份
     */
    private Integer year;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 天数
     */
    private Integer days;

    /**
     * 构造时间控件对象
     */
    public DataTimeControlsDTO() {
        this(0, 0, 0);
    }

    /**
     * 构造时间控件对象
     *
     * @param year  年份
     * @param month 月份
     * @param days  天数
     */
    public DataTimeControlsDTO(int year, int month, int days) {
        this.year = year;
        this.month = month;
        this.days = days;
    }

}

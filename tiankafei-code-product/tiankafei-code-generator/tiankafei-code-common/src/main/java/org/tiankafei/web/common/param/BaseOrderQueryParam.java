package org.tiankafei.web.common.param;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel("可排序查询参数对象")
public abstract class BaseOrderQueryParam extends BaseQueryParam {

    @ApiModelProperty(value = "排序")
    private List<OrderItem> orders;

    @ApiModelProperty(value = "开始时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Timestamp beginTime;

    @ApiModelProperty(value = "结束时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Timestamp endTime;

    public void defaultOrder(OrderItem orderItem) {
        this.defaultOrders(Arrays.asList(orderItem));
    }

    public void defaultOrders(List<OrderItem> orderItems) {
        if (CollectionUtils.isEmpty(orderItems)) {
            return;
        }
        this.orders = orderItems;
    }

}

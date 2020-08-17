package org.tiankafei.web.common.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.tiankafei.web.common.param.BaseOrderQueryParam;
import org.tiankafei.web.common.param.BaseQueryParam;
import org.tiankafei.web.common.service.BaseService;

/**
 * @author tiankafei
 * @since 1.0
 **/
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    protected Page setPageParam(BaseQueryParam baseQueryParam) {
        return setPageParam(baseQueryParam, Arrays.asList());
    }

    protected Page setPageParam(BaseQueryParam baseQueryParam, OrderItem defaultOrder) {
        Page page = new Page();
        // 设置当前页码
        page.setCurrent(baseQueryParam.getCurrent());
        // 设置页大小
        page.setSize(baseQueryParam.getSize());
        /**
         * 如果是queryParam是OrderQueryParam，并且不为空，则使用前端排序
         * 否则使用默认排序
         */
        if (defaultOrder != null) {
            if (baseQueryParam instanceof BaseOrderQueryParam) {
                BaseOrderQueryParam baseOrderQueryParam = (BaseOrderQueryParam) baseQueryParam;
                List<OrderItem> orderItems = baseOrderQueryParam.getOrders();
                if (CollectionUtils.isEmpty(orderItems)) {
                    page.setOrders(Arrays.asList(defaultOrder));
                } else {
                    page.setOrders(orderItems);
                }
            } else {
                page.setOrders(Arrays.asList(defaultOrder));
            }
        }

        return page;
    }

    protected Page setPageParam(BaseQueryParam baseQueryParam, List<OrderItem> defaultOrderList) {
        Page page = new Page();
        // 设置当前页码
        page.setCurrent(baseQueryParam.getCurrent());
        // 设置页大小
        page.setSize(baseQueryParam.getSize());
        /**
         * 如果是queryParam是OrderQueryParam，并且不为空，则使用前端排序
         * 否则使用默认排序
         */
        if (CollectionUtils.isNotEmpty(defaultOrderList)) {
            if (baseQueryParam instanceof BaseOrderQueryParam) {
                BaseOrderQueryParam baseOrderQueryParam = (BaseOrderQueryParam) baseQueryParam;
                List<OrderItem> orderItems = baseOrderQueryParam.getOrders();
                if (CollectionUtils.isEmpty(orderItems)) {
                    page.setOrders(defaultOrderList);
                } else {
                    page.setOrders(orderItems);
                }
            } else {
                page.setOrders(defaultOrderList);
            }
        }

        return page;
    }

}

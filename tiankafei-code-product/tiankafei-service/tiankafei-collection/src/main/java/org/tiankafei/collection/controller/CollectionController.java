package org.tiankafei.collection.controller;

import com.ruoyi.common.core.web.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.collection.bean.ComponentClient;
import org.tiankafei.collection.param.ComponentTypeVo;
import org.tiankafei.web.common.api.ApiResult;

/**
 * 采集相关API
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/collection")
@Api(value = "采集相关API", tags = "采集相关API")
public class CollectionController extends BaseController {

    @Autowired
    private ComponentClient componentClient;

    /**
     * 获取所有的组件类型集合
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/componentTypeList")
    @ApiOperation(value = "获取所有的组件类型集合", notes = "获取所有的组件类型集合")
    public ApiResult<List<ComponentTypeVo>> getFieldEntity() throws Exception {
        List<ComponentTypeVo> componentTypeList = componentClient.getComponentTypeList();
        return ApiResult.ok(componentTypeList);
    }

}

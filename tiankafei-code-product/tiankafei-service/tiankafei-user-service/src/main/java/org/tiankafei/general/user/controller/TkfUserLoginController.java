package org.tiankafei.general.user.controller;

import org.tiankafei.general.user.service.TkfUserLoginService;
import org.tiankafei.general.user.param.TkfUserLoginQueryParam;
import org.tiankafei.general.user.param.TkfUserLoginPageQueryParam;
import org.tiankafei.general.user.vo.TkfUserLoginQueryVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.tiankafei.web.common.vo.Paging;
import org.tiankafei.web.common.param.IdsParam;

import java.util.List;

/**
 * <pre>
 * 用户登录信息表 前端控制器
 * </pre>
 *
 * @author tiankafei
 * @since 2020-06-30
 */
@Slf4j
@RestController
@RequestMapping("/tkfUserLogin")
@Api(value = "用户登录信息表 API", tags = "用户登录信息表 功能维护")
public class TkfUserLoginController extends BaseController {

    @Autowired
    private TkfUserLoginService tkfUserLoginService;

    /**
     * 校验 用户登录信息表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 用户登录信息表 是否已经存在", notes = "校验 用户登录信息表 是否已经存在")
    public ApiResult<Boolean> checkTkfUserLoginExists(@Valid @RequestBody TkfUserLoginQueryParam tkfUserLoginQueryParam) throws Exception {
        Boolean flag = tkfUserLoginService.checkTkfUserLoginExists(tkfUserLoginQueryParam);
        return ApiResult.ok(flag);
    }

    /**
     * 添加 用户登录信息表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 用户登录信息表 对象", notes = "添加 用户登录信息表")
    public ApiResult<String> addTkfUserLogin(@Valid @RequestBody TkfUserLoginQueryVo tkfUserLoginQueryVo) throws Exception {
        Object id = tkfUserLoginService.saveTkfUserLogin(tkfUserLoginQueryVo);
        return ApiResult.ok(id);
    }

    /**
     * 修改 用户登录信息表 对象
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改 用户登录信息表 对象", notes = "修改 用户登录信息表")
    public ApiResult<Boolean> updateTkfUserLogin(@Valid @RequestBody TkfUserLoginQueryVo tkfUserLoginQueryVo) throws Exception {
        boolean flag = tkfUserLoginService.updateTkfUserLogin(tkfUserLoginQueryVo);
        return ApiResult.ok(flag);
    }

    /**
     * 删除 用户登录信息表 对象
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除 用户登录信息表 对象", notes = "删除 用户登录信息表")
    public ApiResult<Boolean> deleteTkfUserLogin(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = tkfUserLoginService.deleteTkfUserLogin(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 获取 用户登录信息表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 用户登录信息表 对象详情", notes = "获取 用户登录信息表 对象详情")
    public ApiResult<TkfUserLoginQueryVo> getTkfUserLogin(@PathVariable("id") String id) throws Exception {
         TkfUserLoginQueryVo tkfUserLoginQueryVo = tkfUserLoginService.getTkfUserLoginById(id);
        return ApiResult.ok(tkfUserLoginQueryVo);
    }

    /**
     * 获取 用户登录信息表 分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取 用户登录信息表 分页列表", notes = "获取 用户登录信息表 分页列表")
    public ApiResult<Paging<TkfUserLoginQueryVo>> getTkfUserLoginPageList(@Valid @RequestBody TkfUserLoginPageQueryParam tkfUserLoginPageQueryParam) throws Exception {
         Paging<TkfUserLoginQueryVo> paging = tkfUserLoginService.getTkfUserLoginPageList(tkfUserLoginPageQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 获取 用户登录信息表 列表
     */
    @PostMapping("/getList")
    @ApiOperation(value = "获取 用户登录信息表 列表", notes = "获取 用户登录信息表 列表")
    public ApiResult<List<TkfUserLoginQueryVo>> getTkfUserLoginList(@Valid @RequestBody TkfUserLoginQueryParam tkfUserLoginQueryParam) throws Exception {
         List<TkfUserLoginQueryVo> paging = tkfUserLoginService.getTkfUserLoginList(tkfUserLoginQueryParam);
        return ApiResult.ok(paging);
    }
    
    /**
     * 计算 用户登录信息表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 用户登录信息表 总记录数", notes = "计算 用户登录信息表 总记录数")
    public ApiResult<Integer> countTkfUserLogin(@Valid @RequestBody TkfUserLoginQueryParam tkfUserLoginQueryParam) throws Exception {
        int count = tkfUserLoginService.countTkfUserLogin(tkfUserLoginQueryParam);
        return ApiResult.ok(count);
    }

}
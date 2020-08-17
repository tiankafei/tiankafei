package org.tiankafei.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tiankafei.user.param.UserRoleCheckParam;
import org.tiankafei.user.param.UserRoleCountParam;
import org.tiankafei.user.param.UserRoleDeleteParam;
import org.tiankafei.user.param.UserRoleListParam;
import org.tiankafei.user.param.UserRolePageParam;
import org.tiankafei.user.service.UserRoleService;
import org.tiankafei.user.vo.UserRoleVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 用户拥有的角色关系表 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/userRole")
@Api(value = "用户拥有的角色关系表 API", tags = {"用户拥有的角色关系表"})
public class UserRoleController extends BaseController {

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 校验 用户拥有的角色关系表 是否已经存在
     *
     * @param userRoleCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 用户拥有的角色关系表 对象是否存在")
    public ApiResult<Boolean> checkUserRoleControllerExists(@Valid @RequestBody UserRoleCheckParam userRoleCheckParam) throws Exception {
        Boolean flag = userRoleService.checkUserRoleServiceExists(userRoleCheckParam);
        return ApiResult.ok(flag);
    }

    /**
     * 保存 用户拥有的角色关系表
     *
     * @param userRoleVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 用户拥有的角色关系表")
    public ApiResult<Long> addUserRoleController(@Valid @RequestBody UserRoleVo userRoleVo) throws Exception {
        Long id = userRoleService.addUserRoleService(userRoleVo);
        return ApiResult.ok(id);
    }

    /**
     * 批量保存 用户拥有的角色关系表
     *
     * @param userRoleVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 用户拥有的角色关系表")
    public ApiResult<List<Long>> batchAddUserRoleController(@Valid @RequestBody List<UserRoleVo> userRoleVoList) throws Exception {
        List<Long> idList = userRoleService.batchAddUserRoleService(userRoleVoList);
        return ApiResult.ok(idList);
    }

    /**
     * 删除 用户拥有的角色关系表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 用户拥有的角色关系表")
    public ApiResult<Boolean> deleteUserRoleController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = userRoleService.deleteUserRoleService(id);
        return ApiResult.ok(flag);
    }

    /**
     * 批量删除 用户拥有的角色关系表
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 用户拥有的角色关系表")
    public ApiResult<Boolean> batchDeleteUserRoleController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = userRoleService.batchDeleteUserRoleService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 根据条件删除 用户拥有的角色关系表
     *
     * @param userRoleDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 用户拥有的角色关系表")
    public ApiResult<Boolean> conditionDeleteUserRoleController(@Valid @RequestBody UserRoleDeleteParam userRoleDeleteParam) throws Exception {
        boolean flag = userRoleService.conditionDeleteUserRoleService(userRoleDeleteParam);
        return ApiResult.ok(flag);
    }

    /**
     * 修改 用户拥有的角色关系表
     *
     * @param userRoleVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 用户拥有的角色关系表")
    public ApiResult<Boolean> updateUserRoleController(@Valid @RequestBody UserRoleVo userRoleVo) throws Exception {
        boolean flag = userRoleService.updateUserRoleService(userRoleVo);
        return ApiResult.ok(flag);
    }

    /**
     * 根据ID获取 用户拥有的角色关系表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 用户拥有的角色关系表 对象")
    public ApiResult<UserRoleVo> getUserRoleController(@PathVariable(value = "id") String id) throws Exception {
        UserRoleVo userRoleVo = userRoleService.getUserRoleServiceById(id);
        return ApiResult.ok(userRoleVo);
    }

    /**
     * 获取 用户拥有的角色关系表 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 用户拥有的角色关系表 对象全部列表")
    public ApiResult<List<UserRoleVo>> getUserRoleControllerAllList() throws Exception {
        List<UserRoleVo> userRoleVoList = userRoleService.getUserRoleServiceList(new UserRoleListParam());
        return ApiResult.ok(userRoleVoList);
    }

    /**
     * 获取 用户拥有的角色关系表 对象列表
     *
     * @param userRoleListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 用户拥有的角色关系表 对象列表")
    public ApiResult<List<UserRoleVo>> getUserRoleControllerList(@Valid @RequestBody UserRoleListParam userRoleListParam) throws Exception {
        List<UserRoleVo> userRoleVoList = userRoleService.getUserRoleServiceList(userRoleListParam);
        return ApiResult.ok(userRoleVoList);
    }

    /**
     * 获取 用户拥有的角色关系表 分页对象列表
     *
     * @param userRolePageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 用户拥有的角色关系表 分页对象列表")
    public ApiResult<Paging<UserRoleVo>> getUserRoleControllerPageList(@Valid @RequestBody UserRolePageParam userRolePageParam) throws Exception {
        Paging<UserRoleVo> userRoleVoList = userRoleService.getUserRoleServicePageList(userRolePageParam);
        return ApiResult.ok(userRoleVoList);
    }

    /**
     * 计算 用户拥有的角色关系表 总记录数
     *
     * @param userRoleCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 用户拥有的角色关系表 对象的记录数")
    public ApiResult<Integer> countUserRoleController(@Valid @RequestBody UserRoleCountParam userRoleCountParam) throws Exception {
        Integer count = userRoleService.countUserRoleService(userRoleCountParam);
        return ApiResult.ok(count);
    }


}


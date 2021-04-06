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
import org.tiankafei.user.param.RoleMenuCheckParam;
import org.tiankafei.user.param.RoleMenuCountParam;
import org.tiankafei.user.param.RoleMenuDeleteParam;
import org.tiankafei.user.param.RoleMenuListParam;
import org.tiankafei.user.param.RoleMenuPageParam;
import org.tiankafei.user.service.RoleMenuService;
import org.tiankafei.user.vo.RoleMenuVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 系统角色对应的功能配置表 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/roleMenu")
@Api(value = "系统角色对应的功能配置表 API", tags = {"系统角色对应的功能配置表"})
public class RoleMenuController extends BaseController {

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 校验 系统角色对应的功能配置表 是否已经存在
     *
     * @param roleMenuCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 系统角色对应的功能配置表 对象是否存在")
    public ApiResult<Boolean> checkRoleMenuControllerExists(@Valid @RequestBody RoleMenuCheckParam roleMenuCheckParam) throws Exception {
        Boolean flag = roleMenuService.checkRoleMenuServiceExists(roleMenuCheckParam);
        return ApiResult.ok(flag);
    }

    /**
     * 保存 系统角色对应的功能配置表
     *
     * @param roleMenuVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 系统角色对应的功能配置表")
    public ApiResult<Long> addRoleMenuController(@Valid @RequestBody RoleMenuVo roleMenuVo) throws Exception {
        Long id = roleMenuService.addRoleMenuService(roleMenuVo);
        return ApiResult.ok(id);
    }

    /**
     * 批量保存 系统角色对应的功能配置表
     *
     * @param roleMenuVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 系统角色对应的功能配置表")
    public ApiResult<List<Long>> batchAddRoleMenuController(@Valid @RequestBody List<RoleMenuVo> roleMenuVoList) throws Exception {
        List<Long> idList = roleMenuService.batchAddRoleMenuService(roleMenuVoList);
        return ApiResult.ok(idList);
    }

    /**
     * 删除 系统角色对应的功能配置表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 系统角色对应的功能配置表")
    public ApiResult<Boolean> deleteRoleMenuController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = roleMenuService.deleteRoleMenuService(id);
        return ApiResult.ok(flag);
    }

    /**
     * 批量删除 系统角色对应的功能配置表
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 系统角色对应的功能配置表")
    public ApiResult<Boolean> batchDeleteRoleMenuController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = roleMenuService.batchDeleteRoleMenuService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 根据条件删除 系统角色对应的功能配置表
     *
     * @param roleMenuDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 系统角色对应的功能配置表")
    public ApiResult<Boolean> conditionDeleteRoleMenuController(@Valid @RequestBody RoleMenuDeleteParam roleMenuDeleteParam) throws Exception {
        boolean flag = roleMenuService.conditionDeleteRoleMenuService(roleMenuDeleteParam);
        return ApiResult.ok(flag);
    }

    /**
     * 修改 系统角色对应的功能配置表
     *
     * @param roleMenuVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 系统角色对应的功能配置表")
    public ApiResult<Boolean> updateRoleMenuController(@Valid @RequestBody RoleMenuVo roleMenuVo) throws Exception {
        boolean flag = roleMenuService.updateRoleMenuService(roleMenuVo);
        return ApiResult.ok(flag);
    }

    /**
     * 根据ID获取 系统角色对应的功能配置表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 系统角色对应的功能配置表 对象")
    public ApiResult<RoleMenuVo> getRoleMenuController(@PathVariable(value = "id") String id) throws Exception {
        RoleMenuVo roleMenuVo = roleMenuService.getRoleMenuServiceById(id);
        return ApiResult.ok(roleMenuVo);
    }

    /**
     * 获取 系统角色对应的功能配置表 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 系统角色对应的功能配置表 对象全部列表")
    public ApiResult<List<RoleMenuVo>> getRoleMenuControllerAllList() throws Exception {
        List<RoleMenuVo> roleMenuVoList = roleMenuService.getRoleMenuServiceList(new RoleMenuListParam());
        return ApiResult.ok(roleMenuVoList);
    }

    /**
     * 获取 系统角色对应的功能配置表 对象列表
     *
     * @param roleMenuListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 系统角色对应的功能配置表 对象列表")
    public ApiResult<List<RoleMenuVo>> getRoleMenuControllerList(@Valid @RequestBody RoleMenuListParam roleMenuListParam) throws Exception {
        List<RoleMenuVo> roleMenuVoList = roleMenuService.getRoleMenuServiceList(roleMenuListParam);
        return ApiResult.ok(roleMenuVoList);
    }

    /**
     * 获取 系统角色对应的功能配置表 分页对象列表
     *
     * @param roleMenuPageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 系统角色对应的功能配置表 分页对象列表")
    public ApiResult<Paging<RoleMenuVo>> getRoleMenuControllerPageList(@Valid @RequestBody RoleMenuPageParam roleMenuPageParam) throws Exception {
        Paging<RoleMenuVo> roleMenuVoList = roleMenuService.getRoleMenuServicePageList(roleMenuPageParam);
        return ApiResult.ok(roleMenuVoList);
    }

    /**
     * 计算 系统角色对应的功能配置表 总记录数
     *
     * @param roleMenuCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 系统角色对应的功能配置表 对象的记录数")
    public ApiResult<Integer> countRoleMenuController(@Valid @RequestBody RoleMenuCountParam roleMenuCountParam) throws Exception {
        Integer count = roleMenuService.countRoleMenuService(roleMenuCountParam);
        return ApiResult.ok(count);
    }


}


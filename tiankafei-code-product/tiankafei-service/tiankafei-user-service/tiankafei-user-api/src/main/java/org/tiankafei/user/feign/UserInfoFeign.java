package org.tiankafei.user.feign;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.tiankafei.user.model.UserInfoDto;
import org.tiankafei.user.param.UserInfoCheckParam;
import org.tiankafei.user.param.UserInfoCountParam;
import org.tiankafei.user.param.UserInfoDeleteParam;
import org.tiankafei.user.param.UserInfoListParam;
import org.tiankafei.user.param.UserInfoPageParam;
import org.tiankafei.user.vo.UserInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "user-service", contextId = "sysUserInfo", path = "/userInfo")
public interface UserInfoFeign {

    @PostMapping("/check")
    @ApiOperation(value = "校验 用户基本信息表 对象是否存在")
    public ApiResult<Boolean> checkUserInfoControllerExists(@Valid @RequestBody UserInfoCheckParam userInfoCheckParam) throws Exception;

    @PostMapping
    @ApiOperation(value = "添加 用户基本信息表")
    public ApiResult<Long> addUserInfoController(@Valid @RequestBody UserInfoDto userInfoVo) throws Exception;

    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 用户基本信息表")
    public ApiResult<List<Long>> batchAddUserInfoController(@Valid @RequestBody List<UserInfoDto> userInfoVoList) throws Exception;

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 用户基本信息表")
    public ApiResult<Boolean> deleteUserInfoController(@PathVariable(value = "id") String id) throws Exception;

    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 用户基本信息表")
    public ApiResult<Boolean> batchDeleteUserInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception;

    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 用户基本信息表")
    public ApiResult<Boolean> conditionDeleteUserInfoController(@Valid @RequestBody UserInfoDeleteParam userInfoDeleteParam) throws Exception;

    @PatchMapping
    @ApiOperation(value = "更新 用户基本信息表")
    public ApiResult<Boolean> updateUserInfoController(@Valid @RequestBody UserInfoDto userInfoVo) throws Exception;

    @GetMapping("/{id}")
    @ApiOperation(value = "获取 用户基本信息表 对象")
    public ApiResult<UserInfoVo> getUserInfoController(@PathVariable(value = "id") String id) throws Exception;

    @GetMapping
    @ApiOperation(value = "获取 用户基本信息表 对象全部列表")
    public ApiResult<List<UserInfoVo>> getUserInfoControllerAllList() throws Exception;

    @PostMapping("/list")
    @ApiOperation(value = "获取 用户基本信息表 对象列表")
    public ApiResult<List<UserInfoVo>> getUserInfoControllerList(@Valid @RequestBody UserInfoListParam userInfoListParam) throws Exception;

    @PostMapping("/pageList")
    @ApiOperation(value = "获取 用户基本信息表 分页对象列表")
    public ApiResult<Paging<UserInfoVo>> getUserInfoControllerPageList(@Valid @RequestBody UserInfoPageParam userInfoPageParam) throws Exception;

    @PostMapping("/count")
    @ApiOperation(value = "求 用户基本信息表 对象的记录数")
    public ApiResult<Integer> countUserInfoController(@Valid @RequestBody UserInfoCountParam userInfoCountParam) throws Exception;

}

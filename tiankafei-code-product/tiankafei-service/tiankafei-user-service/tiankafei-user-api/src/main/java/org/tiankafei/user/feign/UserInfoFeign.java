package org.tiankafei.user.feign;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.tiankafei.user.param.UserInfoPageParam;
import org.tiankafei.user.param.UserInfoListParam;
import org.tiankafei.user.vo.UserInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

import javax.validation.Valid;
import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "user-service", contextId = "sysUserInfo", path = "/sysUserInfo")
public interface UserInfoFeign {

    /**
     * 校验 用户名 是否已经存在
     */
    @GetMapping("/checkUsername/{username}")
    @ApiOperation(value = "校验 用户名 是否已经存在", notes = "校验 用户名 是否已经存在")
    public ApiResult<Boolean> checkUsernameExists(@PathVariable String username) throws Exception;

    /**
     * 校验  邮箱 是否已经存在
     */
    @GetMapping("/checkEmail/{email}")
    @ApiOperation(value = "校验  邮箱 是否已经存在", notes = "校验  邮箱 是否已经存在")
    public ApiResult<Boolean> checkEmailExists(@PathVariable String email) throws Exception;

    /**
     * 校验 手机号码 是否已经存在
     */
    @GetMapping("/checkTelephone/{telephone}")
    @ApiOperation(value = "校验 手机号码 是否已经存在", notes = "校验 手机号码 是否已经存在")
    public ApiResult<Boolean> checkTelephoneExists(@PathVariable String telephone) throws Exception;

    /**
     * 校验 用户基本信息表 是否已经存在
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 用户基本信息表 是否已经存在", notes = "校验 用户基本信息表 是否已经存在")
    public ApiResult<Boolean> checkSysUserInfoExists(@Valid @RequestBody UserInfoListParam userInfoListParam) throws Exception;

    /**
     * 添加 用户基本信息表 对象
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加 用户基本信息表 对象", notes = "添加 用户基本信息表")
    public ApiResult<String> addSysUserInfo(@Valid @RequestBody UserInfoVo userInfoVo) throws Exception;

    /**
     * 修改 用户基本信息表 对象
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改 用户基本信息表 对象", notes = "修改 用户基本信息表")
    public ApiResult<Boolean> updateSysUserInfo(@Valid @RequestBody UserInfoVo userInfoVo) throws Exception;

    /**
     * 删除 用户基本信息表 对象
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除 用户基本信息表 对象", notes = "删除 用户基本信息表")
    public ApiResult<Boolean> deleteSysUserInfo(@Valid @RequestBody IdsParam idsParam) throws Exception;

    /**
     * 获取 用户基本信息表 对象详情
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取 用户基本信息表 对象详情", notes = "获取 用户基本信息表 对象详情")
    public ApiResult<UserInfoVo> getSysUserInfo(@PathVariable("id") String id) throws Exception;

    /**
     * 获取 用户基本信息表 分页列表
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 用户基本信息表 分页列表", notes = "获取 用户基本信息表 分页列表")
    public ApiResult<Paging<UserInfoVo>> getSysUserInfoPageList(@Valid @RequestBody UserInfoPageParam userInfoPageParam) throws Exception;

    /**
     * 获取 用户基本信息表 列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 用户基本信息表 列表", notes = "获取 用户基本信息表 列表")
    public ApiResult<List<UserInfoVo>> getSysUserInfoList(@Valid @RequestBody UserInfoListParam userInfoListParam) throws Exception;

    /**
     * 计算 用户基本信息表 总记录数
     */
    @PostMapping("/count")
    @ApiOperation(value = "计算 用户基本信息表 总记录数", notes = "计算 用户基本信息表 总记录数")
    public ApiResult<Integer> countSysUserInfo(@Valid @RequestBody UserInfoListParam userInfoListParam) throws Exception;

}

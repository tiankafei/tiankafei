package org.tiankafei.user.feign;

import com.ruoyi.common.core.web.page.Paging;
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
import org.tiankafei.user.param.UserInfoCheckParam;
import org.tiankafei.user.param.UserInfoCountParam;
import org.tiankafei.user.param.UserInfoDeleteParam;
import org.tiankafei.user.param.UserInfoListParam;
import org.tiankafei.user.param.UserInfoPageParam;
import org.tiankafei.user.vo.UserInfoVo;
import com.ruoyi.common.core.web.domain.ApiResult;
import org.tiankafei.web.common.param.IdsParam;

/**
 * @author tiankafei
 * @since 1.0
 */
@FeignClient(value = "user-service", contextId = "sysUserInfo", path = "/userInfo")
public interface UserInfoFeign {

    /**
     * 校验 用户名 是否已经存在
     *
     * @param username
     * @return
     * @throws Exception
     */
    @GetMapping("/checkUsername/{username}")
    @ApiOperation(value = "校验 用户名 是否已经存在", notes = "校验 用户名 是否已经存在")
    ApiResult<Boolean> checkUsernameExists(@PathVariable String username) throws Exception;

    /**
     * 校验  邮箱 是否已经存在
     *
     * @param email
     * @return
     * @throws Exception
     */
    @GetMapping("/checkEmail/{email}")
    @ApiOperation(value = "校验  邮箱 是否已经存在", notes = "校验  邮箱 是否已经存在")
    ApiResult<Boolean> checkEmailExists(@PathVariable String email) throws Exception;

    /**
     * 校验 手机号码 是否已经存在
     *
     * @param telephone
     * @return
     * @throws Exception
     */
    @GetMapping("/checkTelephone/{telephone}")
    @ApiOperation(value = "校验 手机号码 是否已经存在", notes = "校验 手机号码 是否已经存在")
    ApiResult<Boolean> checkTelephoneExists(@PathVariable String telephone) throws Exception;

    /**
     * 校验 用户基本信息表 是否已经存在
     *
     * @param userInfoCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 用户基本信息表 对象是否存在")
    ApiResult<Boolean> checkUserInfoControllerExists(@Valid @RequestBody UserInfoCheckParam userInfoCheckParam) throws Exception;

    /**
     * 保存 用户基本信息表
     *
     * @param userInfoVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 用户基本信息表")
    ApiResult<Long> addUserInfoController(@Valid @RequestBody UserInfoVo userInfoVo) throws Exception;

    /**
     * 批量保存 用户基本信息表
     *
     * @param userInfoVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 用户基本信息表")
    ApiResult<List<Long>> batchAddUserInfoController(@Valid @RequestBody List<UserInfoVo> userInfoVoList) throws Exception;

    /**
     * 删除 用户基本信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 用户基本信息表")
    ApiResult<Boolean> deleteUserInfoController(@PathVariable(value = "id") String id) throws Exception;

    /**
     * 批量删除 用户基本信息表
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 用户基本信息表")
    ApiResult<Boolean> batchDeleteUserInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception;

    /**
     * 根据条件删除 用户基本信息表
     *
     * @param userInfoDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 用户基本信息表")
    ApiResult<Boolean> conditionDeleteUserInfoController(@Valid @RequestBody UserInfoDeleteParam userInfoDeleteParam) throws Exception;

    /**
     * 修改 用户基本信息表
     *
     * @param userInfoVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 用户基本信息表")
    ApiResult<Boolean> updateUserInfoController(@Valid @RequestBody UserInfoVo userInfoVo) throws Exception;

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 用户基本信息表 对象")
    ApiResult<UserInfoVo> getUserInfoController(@PathVariable(value = "id") String id) throws Exception;

    /**
     * 获取 用户基本信息表 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 用户基本信息表 对象全部列表")
    ApiResult<List<UserInfoVo>> getUserInfoControllerAllList() throws Exception;

    /**
     * 获取 用户基本信息表 对象列表
     *
     * @param userInfoListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 用户基本信息表 对象列表")
    ApiResult<List<UserInfoVo>> getUserInfoControllerList(@Valid @RequestBody UserInfoListParam userInfoListParam) throws Exception;

    /**
     * 获取 用户基本信息表 分页对象列表
     *
     * @param userInfoPageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 用户基本信息表 分页对象列表")
    ApiResult<Paging<UserInfoVo>> getUserInfoControllerPageList(@Valid @RequestBody UserInfoPageParam userInfoPageParam) throws Exception;

    /**
     * 计算 用户基本信息表 总记录数
     *
     * @param userInfoCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 用户基本信息表 对象的记录数")
    ApiResult<Integer> countUserInfoController(@Valid @RequestBody UserInfoCountParam userInfoCountParam) throws Exception;

}

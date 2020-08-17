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
import org.tiankafei.user.param.UserInfoCheckParam;
import org.tiankafei.user.param.UserInfoCountParam;
import org.tiankafei.user.param.UserInfoDeleteParam;
import org.tiankafei.user.param.UserInfoListParam;
import org.tiankafei.user.param.UserInfoPageParam;
import org.tiankafei.user.service.UserInfoService;
import org.tiankafei.user.vo.UserInfoVo;
import org.tiankafei.web.common.api.ApiResult;
import org.tiankafei.web.common.controller.BaseController;
import org.tiankafei.web.common.param.IdsParam;
import org.tiankafei.web.common.vo.Paging;

/**
 * <p>
 * 用户基本信息表 前端控制器
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@RestController
@RequestMapping("/userInfo")
@Api(value = "用户基本信息表 API", tags = {"用户基本信息表"})
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 校验 用户名 是否已经存在
     *
     * @param username
     * @return
     * @throws Exception
     */
    @GetMapping("/checkUsername/{username}")
    @ApiOperation(value = "校验 用户名 是否已经存在", notes = "校验 用户名 是否已经存在")
    public ApiResult<Boolean> checkUsernameExists(@PathVariable String username) throws Exception {
        Boolean flag = userInfoService.checkUsernameExists(username);
        return ApiResult.ok(flag);
    }

    /**
     * 校验  邮箱 是否已经存在
     * @param email
     * @return
     * @throws Exception
     */
    @GetMapping("/checkEmail/{email}")
    @ApiOperation(value = "校验  邮箱 是否已经存在", notes = "校验  邮箱 是否已经存在")
    public ApiResult<Boolean> checkEmailExists(@PathVariable String email) throws Exception {
        Boolean flag = userInfoService.checkEmailExists(email);
        return ApiResult.ok(flag);
    }

    /**
     * 校验 手机号码 是否已经存在
     *
     * @param telephone
     * @return
     * @throws Exception
     */
    @GetMapping("/checkTelephone/{telephone}")
    @ApiOperation(value = "校验 手机号码 是否已经存在", notes = "校验 手机号码 是否已经存在")
    public ApiResult<Boolean> checkTelephoneExists(@PathVariable String telephone) throws Exception {
        Boolean flag = userInfoService.checkTelephoneExists(telephone);
        return ApiResult.ok(flag);
    }

    /**
     * 校验 用户基本信息表 是否已经存在
     *
     * @param userInfoCheckParam
     * @return
     * @throws Exception
     */
    @PostMapping("/check")
    @ApiOperation(value = "校验 用户基本信息表 对象是否存在")
    public ApiResult<Boolean> checkUserInfoControllerExists(@Valid @RequestBody UserInfoCheckParam userInfoCheckParam) throws Exception {
        Boolean flag = userInfoService.checkUserInfoServiceExists(userInfoCheckParam);
        return ApiResult.ok(flag);
    }

    /**
     * 保存 用户基本信息表
     *
     * @param userInfoVo
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "添加 用户基本信息表")
    public ApiResult<Long> addUserInfoController(@Valid @RequestBody UserInfoVo userInfoVo) throws Exception {
        Long id = userInfoService.addUserInfoService(userInfoVo);
        return ApiResult.ok(id);
    }

    /**
     * 批量保存 用户基本信息表
     *
     * @param userInfoVoList
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量添加 用户基本信息表")
    public ApiResult<List<Long>> batchAddUserInfoController(@Valid @RequestBody List<UserInfoVo> userInfoVoList) throws Exception {
        List<Long> idList = userInfoService.batchAddUserInfoService(userInfoVoList);
        return ApiResult.ok(idList);
    }

    /**
     * 删除 用户基本信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 用户基本信息表")
    public ApiResult<Boolean> deleteUserInfoController(@PathVariable(value = "id") String id) throws Exception {
        boolean flag = userInfoService.deleteUserInfoService(id);
        return ApiResult.ok(flag);
    }

    /**
     * 批量删除 用户基本信息表
     *
     * @param idsParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/batch")
    @ApiOperation(value = "批量删除 用户基本信息表")
    public ApiResult<Boolean> batchDeleteUserInfoController(@Valid @RequestBody IdsParam idsParam) throws Exception {
        boolean flag = userInfoService.batchDeleteUserInfoService(idsParam.getIds());
        return ApiResult.ok(flag);
    }

    /**
     * 根据条件删除 用户基本信息表
     *
     * @param userInfoDeleteParam
     * @return
     * @throws Exception
     */
    @DeleteMapping("/condition")
    @ApiOperation(value = "条件删除 用户基本信息表")
    public ApiResult<Boolean> conditionDeleteUserInfoController(@Valid @RequestBody UserInfoDeleteParam userInfoDeleteParam) throws Exception {
        boolean flag = userInfoService.conditionDeleteUserInfoService(userInfoDeleteParam);
        return ApiResult.ok(flag);
    }

    /**
     * 修改 用户基本信息表
     *
     * @param userInfoVo
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ApiOperation(value = "修改 用户基本信息表")
    public ApiResult<Boolean> updateUserInfoController(@Valid @RequestBody UserInfoVo userInfoVo) throws Exception {
        boolean flag = userInfoService.updateUserInfoService(userInfoVo);
        return ApiResult.ok(flag);
    }

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取 用户基本信息表 对象")
    public ApiResult<UserInfoVo> getUserInfoController(@PathVariable(value = "id") String id) throws Exception {
        UserInfoVo userInfoVo = userInfoService.getUserInfoServiceById(id);
        return ApiResult.ok(userInfoVo);
    }

    /**
     * 获取 用户基本信息表 对象列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping
    @ApiOperation(value = "获取 用户基本信息表 对象全部列表")
    public ApiResult<List<UserInfoVo>> getUserInfoControllerAllList() throws Exception {
        List<UserInfoVo> userInfoVoList = userInfoService.getUserInfoServiceList(new UserInfoListParam());
        return ApiResult.ok(userInfoVoList);
    }

    /**
     * 获取 用户基本信息表 对象列表
     *
     * @param userInfoListParam
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取 用户基本信息表 对象列表")
    public ApiResult<List<UserInfoVo>> getUserInfoControllerList(@Valid @RequestBody UserInfoListParam userInfoListParam) throws Exception {
        List<UserInfoVo> userInfoVoList = userInfoService.getUserInfoServiceList(userInfoListParam);
        return ApiResult.ok(userInfoVoList);
    }

    /**
     * 获取 用户基本信息表 分页对象列表
     *
     * @param userInfoPageParam
     * @return
     * @throws Exception
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取 用户基本信息表 分页对象列表")
    public ApiResult<Paging<UserInfoVo>> getUserInfoControllerPageList(@Valid @RequestBody UserInfoPageParam userInfoPageParam) throws Exception {
        Paging<UserInfoVo> userInfoVoList = userInfoService.getUserInfoServicePageList(userInfoPageParam);
        return ApiResult.ok(userInfoVoList);
    }

    /**
     * 计算 用户基本信息表 总记录数
     *
     * @param userInfoCountParam
     * @return
     * @throws Exception
     */
    @PostMapping("/count")
    @ApiOperation(value = "求 用户基本信息表 对象的记录数")
    public ApiResult<Integer> countUserInfoController(@Valid @RequestBody UserInfoCountParam userInfoCountParam) throws Exception {
        Integer count = userInfoService.countUserInfoService(userInfoCountParam);
        return ApiResult.ok(count);
    }


}


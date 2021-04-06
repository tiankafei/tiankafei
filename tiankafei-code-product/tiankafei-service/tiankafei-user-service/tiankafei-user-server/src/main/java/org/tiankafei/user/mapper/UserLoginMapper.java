package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.UserLoginEntity;
import org.tiankafei.user.param.UserLoginCheckParam;
import org.tiankafei.user.param.UserLoginCountParam;
import org.tiankafei.user.param.UserLoginDeleteParam;
import org.tiankafei.user.param.UserLoginListParam;
import org.tiankafei.user.param.UserLoginPageParam;
import org.tiankafei.user.vo.UserLoginVo;

/**
 * <p>
 * 用户登录信息表 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface UserLoginMapper extends BaseMapper<UserLoginEntity> {

    /**
     * 校验 用户登录信息表 是否已经存在
     *
     * @param userLoginCheckParam
     * @return
     * @throws Exception
     */
    boolean checkUserLoginServiceExists(@Param("param") UserLoginCheckParam userLoginCheckParam) throws Exception;

    /**
     * 保存 用户登录信息表
     *
     * @param userLoginVo
     * @return
     * @throws Exception
     */
    Object addUserLoginService(@Param("param") UserLoginVo userLoginVo) throws Exception;

    /**
     * 批量保存 用户登录信息表
     *
     * @param userLoginVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddUserLoginService(@Param("param") List<UserLoginVo> userLoginVoList) throws Exception;

    /**
     * 删除 用户登录信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUserLoginService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 用户登录信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteUserLoginService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 用户登录信息表
     *
     * @param userLoginDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteUserLoginService(@Param("param") UserLoginDeleteParam userLoginDeleteParam) throws Exception;

    /**
     * 修改 用户登录信息表
     *
     * @param userLoginVo
     * @return
     * @throws Exception
     */
    boolean updateUserLoginService(@Param("param") UserLoginVo userLoginVo) throws Exception;

    /**
     * 根据ID获取 用户登录信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserLoginVo getUserLoginServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 用户登录信息表 对象列表
     *
     * @param userLoginListParam
     * @return
     * @throws Exception
     */
    List<UserLoginVo> getUserLoginServiceList(@Param("param") UserLoginListParam userLoginListParam) throws Exception;

    /**
     * 获取 用户登录信息表 分页对象列表
     *
     * @param page
     * @param userLoginPageParam
     * @return
     * @throws Exception
     */
    IPage<UserLoginVo> getUserLoginServicePageList(@Param("page") Page page, @Param("param") UserLoginPageParam userLoginPageParam) throws Exception;

    /**
     * 计算 用户登录信息表 总记录数
     *
     * @param userLoginCountParam
     * @return
     * @throws Exception
     */
    Integer countUserLoginService(@Param("param") UserLoginCountParam userLoginCountParam) throws Exception;

}

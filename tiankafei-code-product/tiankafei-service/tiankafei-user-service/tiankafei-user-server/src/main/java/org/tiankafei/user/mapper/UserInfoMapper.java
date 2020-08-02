package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.UserInfoEntity;
import org.tiankafei.user.param.UserInfoCheckParam;
import org.tiankafei.user.param.UserInfoCountParam;
import org.tiankafei.user.param.UserInfoDeleteParam;
import org.tiankafei.user.param.UserInfoListParam;
import org.tiankafei.user.param.UserInfoPageParam;
import org.tiankafei.user.vo.UserInfoVo;

/**
 * <p>
 * 用户基本信息表 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfoEntity> {

    /**
     * 校验 用户基本信息表 是否已经存在
     *
     * @param userInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkUserInfoServiceExists(@Param("param") UserInfoCheckParam userInfoCheckParam) throws Exception;

    /**
     * 保存 用户基本信息表
     *
     * @param userInfoVo
     * @return
     * @throws Exception
     */
    Object addUserInfoService(@Param("param") UserInfoVo userInfoVo) throws Exception;

    /**
     * 批量保存 用户基本信息表
     *
     * @param userInfoVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddUserInfoService(@Param("param") List<UserInfoVo> userInfoVoList) throws Exception;

    /**
     * 删除 用户基本信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUserInfoService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 用户基本信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteUserInfoService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 用户基本信息表
     *
     * @param userInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteUserInfoService(@Param("param") UserInfoDeleteParam userInfoDeleteParam) throws Exception;

    /**
     * 修改 用户基本信息表
     *
     * @param userInfoVo
     * @return
     * @throws Exception
     */
    boolean updateUserInfoService(@Param("param") UserInfoVo userInfoVo) throws Exception;

    /**
     * 根据ID获取 用户基本信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfoVo getUserInfoServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 用户基本信息表 对象列表
     *
     * @param userInfoListParam
     * @return
     * @throws Exception
     */
    List<UserInfoVo> getUserInfoServiceList(@Param("param") UserInfoListParam userInfoListParam) throws Exception;

    /**
     * 获取 用户基本信息表 分页对象列表
     *
     * @param page
     * @param userInfoPageParam
     * @return
     * @throws Exception
     */
    IPage<UserInfoVo> getUserInfoServicePageList(@Param("page") Page page, @Param("param") UserInfoPageParam userInfoPageParam) throws Exception;

    /**
     * 计算 用户基本信息表 总记录数
     *
     * @param userInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countUserInfoService(@Param("param") UserInfoCountParam userInfoCountParam) throws Exception;

}

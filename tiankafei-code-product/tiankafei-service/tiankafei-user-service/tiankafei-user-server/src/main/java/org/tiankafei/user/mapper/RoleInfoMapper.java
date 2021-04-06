package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.RoleInfoEntity;
import org.tiankafei.user.param.RoleInfoCheckParam;
import org.tiankafei.user.param.RoleInfoCountParam;
import org.tiankafei.user.param.RoleInfoDeleteParam;
import org.tiankafei.user.param.RoleInfoListParam;
import org.tiankafei.user.param.RoleInfoPageParam;
import org.tiankafei.user.vo.RoleInfoVo;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface RoleInfoMapper extends BaseMapper<RoleInfoEntity> {

    /**
     * 校验 角色信息表 是否已经存在
     *
     * @param roleInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkRoleInfoServiceExists(@Param("param") RoleInfoCheckParam roleInfoCheckParam) throws Exception;

    /**
     * 保存 角色信息表
     *
     * @param roleInfoVo
     * @return
     * @throws Exception
     */
    Object addRoleInfoService(@Param("param") RoleInfoVo roleInfoVo) throws Exception;

    /**
     * 批量保存 角色信息表
     *
     * @param roleInfoVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddRoleInfoService(@Param("param") List<RoleInfoVo> roleInfoVoList) throws Exception;

    /**
     * 删除 角色信息表
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRoleInfoService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 角色信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteRoleInfoService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 角色信息表
     *
     * @param roleInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteRoleInfoService(@Param("param") RoleInfoDeleteParam roleInfoDeleteParam) throws Exception;

    /**
     * 修改 角色信息表
     *
     * @param roleInfoVo
     * @return
     * @throws Exception
     */
    boolean updateRoleInfoService(@Param("param") RoleInfoVo roleInfoVo) throws Exception;

    /**
     * 根据ID获取 角色信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    RoleInfoVo getRoleInfoServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 角色信息表 对象列表
     *
     * @param roleInfoListParam
     * @return
     * @throws Exception
     */
    List<RoleInfoVo> getRoleInfoServiceList(@Param("param") RoleInfoListParam roleInfoListParam) throws Exception;

    /**
     * 获取 角色信息表 分页对象列表
     *
     * @param page
     * @param roleInfoPageParam
     * @return
     * @throws Exception
     */
    IPage<RoleInfoVo> getRoleInfoServicePageList(@Param("page") Page page, @Param("param") RoleInfoPageParam roleInfoPageParam) throws Exception;

    /**
     * 计算 角色信息表 总记录数
     *
     * @param roleInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countRoleInfoService(@Param("param") RoleInfoCountParam roleInfoCountParam) throws Exception;

}

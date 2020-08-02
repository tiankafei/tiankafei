package org.tiankafei.user.service;

import java.io.Serializable;
import java.util.List;
import org.tiankafei.user.entity.DictInfoEntity;
import org.tiankafei.user.param.DictInfoListParam;
import org.tiankafei.user.param.DictInfoPageParam;
import org.tiankafei.user.vo.DictInfoVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

/**
 * <pre>
 * 系统数据字典表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
public interface DictInfoService extends BaseService<DictInfoEntity> {

    /**
     * 校验 系统数据字典表 是否已经存在
     *
     * @param dictInfoListParam
     * @return
     * @throws Exception
     */
    boolean checkSysDictInfoExists(DictInfoListParam dictInfoListParam) throws Exception;

    /**
     * 保存 系统数据字典表
     *
     * @param dictInfoVo
     * @return
     * @throws Exception
     */
    Object addSysDictInfo(DictInfoVo dictInfoVo) throws Exception;

    /**
     * 保存 系统数据字典表 集合
     *
     * @param dictInfoVoList
     * @return
     * @throws Exception
     */
    boolean addSysDictInfoList(List<DictInfoVo> dictInfoVoList) throws Exception;

    /**
     * 修改 系统数据字典表
     *
     * @param dictInfoVo
     * @return
     * @throws Exception
     */
    boolean updateSysDictInfo(DictInfoVo dictInfoVo) throws Exception;

    /**
     * 启用字段
     *
     * @param id 字典id
     * @return
     * @throws Exception
     */
    boolean enable(String id) throws Exception;

    /**
     * 禁用字典
     *
     * @param id 字典id
     * @return
     * @throws Exception
     */
    boolean disable(String id) throws Exception;

    /**
     * 删除 系统数据字典表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteSysDictInfo(String ids) throws Exception;

    /**
     * 根据条件删除 系统数据字典表
     *
     * @param dictInfoListParam
     * @return
     * @throws Exception
     */
    boolean deleteSysDictInfo(DictInfoListParam dictInfoListParam) throws Exception;

    /**
     * 根据ID获取 系统数据字典表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    DictInfoVo getSysDictInfoById(Serializable id) throws Exception;

    /**
     * 获取 系统数据字典表 分页对象列表
     *
     * @param dictInfoPageParam
     * @return
     * @throws Exception
     */
    Paging<DictInfoVo> getSysDictInfoPageList(DictInfoPageParam dictInfoPageParam) throws Exception;

    /**
     * 获取 系统数据字典表 对象列表
     *
     * @param dictInfoListParam
     * @return
     * @throws Exception
     */
    List<DictInfoVo> getSysDictInfoList(DictInfoListParam dictInfoListParam) throws Exception;

    /**
     * 计算 系统数据字典表 总记录数
     *
     * @param dictInfoListParam
     * @return
     * @throws Exception
     */
    int countSysDictInfo(DictInfoListParam dictInfoListParam) throws Exception;

}
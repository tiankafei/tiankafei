package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.LinksInfoEntity;
import org.tiankafei.user.param.LinksInfoCheckParam;
import org.tiankafei.user.param.LinksInfoCountParam;
import org.tiankafei.user.param.LinksInfoDeleteParam;
import org.tiankafei.user.param.LinksInfoListParam;
import org.tiankafei.user.param.LinksInfoPageParam;
import org.tiankafei.user.vo.LinksInfoVo;

/**
 * <p>
 * 系统的友情链接 Mapper 接口
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface LinksInfoMapper extends BaseMapper<LinksInfoEntity> {

    /**
     * 校验 系统的友情链接 是否已经存在
     *
     * @param linksInfoCheckParam
     * @return
     * @throws Exception
     */
    boolean checkLinksInfoServiceExists(@Param("param") LinksInfoCheckParam linksInfoCheckParam) throws Exception;

    /**
     * 保存 系统的友情链接
     *
     * @param linksInfoVo
     * @return
     * @throws Exception
     */
    Object addLinksInfoService(@Param("param") LinksInfoVo linksInfoVo) throws Exception;

    /**
     * 批量保存 系统的友情链接
     *
     * @param linksInfoVoList
     * @return
     * @throws Exception
     */
    List<Object> batchAddLinksInfoService(@Param("param") List<LinksInfoVo> linksInfoVoList) throws Exception;

    /**
     * 删除 系统的友情链接
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteLinksInfoService(@Param("param") String id) throws Exception;

    /**
     * 批量删除 系统的友情链接
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean batchDeleteLinksInfoService(@Param("param") String ids) throws Exception;

    /**
     * 根据条件删除 系统的友情链接
     *
     * @param linksInfoDeleteParam
     * @return
     * @throws Exception
     */
    boolean conditionDeleteLinksInfoService(@Param("param") LinksInfoDeleteParam linksInfoDeleteParam) throws Exception;

    /**
     * 修改 系统的友情链接
     *
     * @param linksInfoVo
     * @return
     * @throws Exception
     */
    boolean updateLinksInfoService(@Param("param") LinksInfoVo linksInfoVo) throws Exception;

    /**
     * 根据ID获取 系统的友情链接 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    LinksInfoVo getLinksInfoServiceById(@Param("param") Serializable id) throws Exception;

    /**
     * 获取 系统的友情链接 对象列表
     *
     * @param linksInfoListParam
     * @return
     * @throws Exception
     */
    List<LinksInfoVo> getLinksInfoServiceList(@Param("param") LinksInfoListParam linksInfoListParam) throws Exception;

    /**
     * 获取 系统的友情链接 分页对象列表
     *
     * @param page
     * @param linksInfoPageParam
     * @return
     * @throws Exception
     */
    IPage<LinksInfoVo> getLinksInfoServicePageList(@Param("page") Page page, @Param("param") LinksInfoPageParam linksInfoPageParam) throws Exception;

    /**
     * 计算 系统的友情链接 总记录数
     *
     * @param linksInfoCountParam
     * @return
     * @throws Exception
     */
    Integer countLinksInfoService(@Param("param") LinksInfoCountParam linksInfoCountParam) throws Exception;

}

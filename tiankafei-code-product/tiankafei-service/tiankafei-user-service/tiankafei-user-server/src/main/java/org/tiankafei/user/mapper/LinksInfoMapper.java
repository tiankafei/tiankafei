package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.LinksInfoEntity;
import org.tiankafei.user.param.LinksInfoListParam;
import org.tiankafei.user.param.LinksInfoPageParam;
import org.tiankafei.user.vo.LinksInfoVo;

/**
 * <pre>
 * 系统的友情链接 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface LinksInfoMapper extends BaseMapper<LinksInfoEntity> {

    /**
     * 根据ID获取 系统的友情链接 对象
     *
     * @param id
     * @return
     */
    LinksInfoVo getSysLinksById(Serializable id);

    /**
     * 获取 系统的友情链接 分页对象
     *
     * @param page
     * @param linksInfoPageParam
     * @return
     */
    IPage<LinksInfoVo> getSysLinksPageList(@Param("page") Page page, @Param("param") LinksInfoPageParam linksInfoPageParam);

    /**
     * 获取 系统的友情链接 对象列表
     *
     * @param linksInfoListParam
     * @return
     */
    List<LinksInfoVo> getSysLinksList(@Param("param") LinksInfoListParam linksInfoListParam);

}
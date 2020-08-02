package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.DictInfoEntity;
import org.tiankafei.user.param.DictInfoListParam;
import org.tiankafei.user.param.DictInfoPageParam;
import org.tiankafei.user.vo.DictInfoVo;

/**
 * <pre>
 * 系统数据字典表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface DictInfoMapper extends BaseMapper<DictInfoEntity> {

    /**
     * 根据ID获取 系统数据字典表 对象
     *
     * @param id
     * @return
     */
    DictInfoVo getSysDictInfoById(Serializable id);

    /**
     * 获取 系统数据字典表 分页对象
     *
     * @param page
     * @param dictInfoPageParam
     * @return
     */
    IPage<DictInfoVo> getSysDictInfoPageList(@Param("page") Page page, @Param("param") DictInfoPageParam dictInfoPageParam);

    /**
     * 获取 系统数据字典表 对象列表
     *
     * @param dictInfoListParam
     * @return
     */
    List<DictInfoVo> getSysDictInfoList(@Param("param") DictInfoListParam dictInfoListParam);

}
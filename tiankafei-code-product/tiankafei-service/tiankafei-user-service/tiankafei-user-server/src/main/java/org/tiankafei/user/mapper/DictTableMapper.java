package org.tiankafei.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.entity.DictTableEntity;
import org.tiankafei.user.param.DictTableListParam;
import org.tiankafei.user.param.DictTablePageParam;
import org.tiankafei.user.vo.DictTableVo;

/**
 * <pre>
 * 系统数据字典的数据表 Mapper 接口
 * </pre>
 *
 * @author tiankafei
 * @since 1.0
 */
@Repository
public interface DictTableMapper extends BaseMapper<DictTableEntity> {

    /**
     * 根据ID获取 系统数据字典的数据表 对象
     *
     * @param id
     * @return
     */
    DictTableVo getSysDictTableById(Serializable id);

    /**
     * 获取 系统数据字典的数据表 分页对象
     *
     * @param page
     * @param dictTablePageParam
     * @return
     */
    IPage<DictTableVo> getSysDictTablePageList(@Param("page") Page page, @Param("param") DictTablePageParam dictTablePageParam);

    /**
     * 获取 系统数据字典的数据表 对象列表
     *
     * @param dictTableListParam
     * @return
     */
    List<DictTableVo> getSysDictTableList(@Param("param") DictTableListParam dictTableListParam);

}
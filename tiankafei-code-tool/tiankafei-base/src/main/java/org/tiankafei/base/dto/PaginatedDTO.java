package org.tiankafei.base.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页对象
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class PaginatedDTO implements Serializable {

    private static final long serialVersionUID = 1459983610660888420L;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页显示数量
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer pageCount;

    /**
     * 总记录数
     */
    private Integer recordCount;

    /**
     * 开始位置
     */
    private Integer beginRecordIndex;

    /**
     * 结束位置
     */
    private Integer endRecordIndex;

    /**
     * 构造分页对象
     */
    public PaginatedDTO() {
        this(1, 20);
    }

    /**
     * 构造分页对象
     *
     * @param currentPage 当前页
     * @param pageSize    每页显示数量
     */
    public PaginatedDTO(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        recordCount = 0;
    }

    /**
     * @Description: 获取总页数
     * @Param: []
     * @Return: java.lang.Integer
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public Integer getPageCount() {
        if (getRecordCount() % getPageSize() == 0) {
            pageCount = getRecordCount() / getPageSize();
        } else {
            pageCount = getRecordCount() / getPageSize() + 1;
        }
        return pageCount;
    }

    /**
     * @Description: 获取开始的位置
     * @Param: []
     * @Return: java.lang.Integer
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public Integer getBeginRecordIndex() {
        beginRecordIndex = (currentPage - 1) * pageSize;
        return beginRecordIndex;
    }

    /**
     * @Description: 获取结束的位置
     * @Param: []
     * @Return: java.lang.Integer
     * @Author: tiankafei
     * @Date: 2019/10/22
     **/
    public Integer getEndRecordIndex() {
        endRecordIndex = currentPage * pageSize;
        if (endRecordIndex > recordCount) {
            endRecordIndex = recordCount;
        }
        return endRecordIndex;
    }

}

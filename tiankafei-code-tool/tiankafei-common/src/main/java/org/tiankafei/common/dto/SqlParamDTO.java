package org.tiankafei.common.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * SQL参数对象
 *
 * @author tiankafei
 * @since 1.0
 **/
@Data
@Accessors(chain = true)
public class SqlParamDTO implements Serializable {

    /**
     * sql
     */
    private String sql;

    /**
     * 总数的sql
     */
    private String totalSql;

    /**
     * 单条sql执行的参数
     */
    private List<Object> paramList;

    /**
     * 批量sql执行的参数
     */
    private List<List<Object>> paramListList;

    public SqlParamDTO() {
    }

    public SqlParamDTO(String sql) {
        this.sql = sql;
    }

    public SqlParamDTO(String sql, List<Object> paramList) {
        this.sql = sql;
        this.paramList = paramList;
    }

}

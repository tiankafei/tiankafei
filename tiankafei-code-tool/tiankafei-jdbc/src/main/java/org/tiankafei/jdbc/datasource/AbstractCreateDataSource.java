package org.tiankafei.jdbc.datasource;

import javax.sql.DataSource;
import org.tiankafei.jdbc.dto.DataSourceDTO;

/**
 * 创建数据源
 *
 * @author 甜咖啡
 */
public abstract class AbstractCreateDataSource {

    /**
     * 创建数据源
     *
     * @param dataSourceDTO 数据源参数对象
     * @return 数据源
     */
    public abstract DataSource createDataSource(DataSourceDTO dataSourceDTO);

}

package org.tiankafei.jdbc.datasource.druid;

import javax.sql.DataSource;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.jdbc.datasource.AbstractCreateDataSource;
import org.tiankafei.jdbc.dto.DataSourceDTO;

/**
 * 创建druid数据源
 *
 * @author 甜咖啡
 */
public class CreateDruidDataSource extends AbstractCreateDataSource {

    @Override
    public DataSource createDataSource(DataSourceDTO dataSourceDTO) throws BaseException {
        return null;
    }

}

package org.tiankafei.jdbc.datasource.jndi;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.jdbc.datasource.AbstractCreateDataSource;
import org.tiankafei.jdbc.dto.DataSourceDTO;
import org.tiankafei.jdbc.util.ConnectionUtil;

/**
 * 创建jnid数据源
 *
 * @author 甜咖啡
 */
public class CreateJndiDataSource extends AbstractCreateDataSource {

    @Override
    public DataSource createDataSource(DataSourceDTO dataSourceDTO) throws BaseException {
        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup(dataSourceDTO.getJndiName());
            ConnectionUtil.initDatabaseConnectionParamVO(dataSource);
            return dataSource;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

}

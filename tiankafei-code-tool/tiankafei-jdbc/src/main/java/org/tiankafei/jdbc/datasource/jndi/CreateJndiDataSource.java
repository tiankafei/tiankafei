package org.tiankafei.jdbc.datasource.jndi;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.tiankafei.common.exceptions.CommonException;
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
    public DataSource createDataSource(DataSourceDTO dataSourceDTO) {
        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup(dataSourceDTO.getJndiName());
            ConnectionUtil.initDatabaseConnectionParamVO(dataSource);
            return dataSource;
        } catch (NamingException e) {
            e.printStackTrace();
            throw new CommonException("创建jndi数据库链接失败！");
        }
    }

}

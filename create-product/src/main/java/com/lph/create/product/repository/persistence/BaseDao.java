package com.lph.create.product.repository.persistence;

import com.lph.create.product.common.listener.JooqLogListener;
import com.lph.create.product.repository.jooq.Tables;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 蒋文龙(Vin)
 * @date 2018/8/15
 */
@Repository
public abstract class BaseDao extends Tables {
    private DataSource dataSource;
    DSLContext create;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    private void init() throws SQLException {
        //添加JOOQ事务
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(dataSource);
        Configuration configuration = new DefaultConfiguration().set(new DataSourceConnectionProvider(proxy)).set(getType());
        configuration.set(new JooqLogListener());
        create = DSL.using(configuration);
    }

    private SQLDialect getType() throws SQLException {
        SQLDialect sqlType = SQLDialect.MYSQL;
        try (Connection conn = dataSource.getConnection()) {
            String type = conn.getMetaData().getDriverName();
            if (type.startsWith("H2")) {
                sqlType = SQLDialect.H2;
            }
        }
        return sqlType;
    }

}

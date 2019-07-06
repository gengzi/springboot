package club.gsjblog.springboot.freemark.jdbctemplate.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;


import javax.sql.DataSource;
import javax.transaction.UserTransaction;

/**
 * Created by Administrator on 2019/7/2.
 * 获取mysql 的数据库连接池
 */
@Configuration
public class MysqlDataSourceConfig {
//    /**
//     * springboot 使用默认配置的数据库连接池
//     * @return
//     */
//    @Bean("mysqlDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.mysql")
//    public DataSource getmmDataSource(){
//
//        return DataSourceBuilder.create().build();
//    }


    /**
     * 使用 MysqlXADataSource 来配置数据源
     *
     * @return
     */
    @Bean("mysqlDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource getmmDataSource() {

//        ## mysql连接
//        spring.datasource.mysql.url = jdbc:mysql://localhost:3306/sqltest?useUnicode=true&characterEncoding=utf8&useSSL=false
//        spring.datasource.mysql.username = root
//        spring.datasource.mysql.password = 111
//        spring.datasource.mysql.driverClassName = com.mysql.jdbc.Driver

//        ## oracle连接
//        spring.datasource.oracle.url = jdbc:oracle:thin:@//127.0.0.1:1521/orcl
//                spring.datasource.oracle.username = scott
//        spring.datasource.oracle.password = tiger
//        spring.datasource.oracle.driverClassName = oracle.jdbc.driver.OracleDriver
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL("jdbc:mysql://localhost:3306/sqltest?useUnicode=true&characterEncoding=utf8&useSSL=false");
        mysqlXADataSource.setUser("root");
        mysqlXADataSource.setPassword("111");
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setXaDataSource(mysqlXADataSource);
        return ds;
    }


    /**
     * jdbctemplate   spring 提供用于操作JDBC 的工具类 ，类似于 DBUtils
     *
     * @param dataSource
     * @return
     */
    @Bean("msqlJdbcTemplate")
    @Primary
    public JdbcTemplate getmmJdbcTemplate(@Qualifier("mysqlDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

//    /**
//     * 平台事物管理器
//     *
//     * @param dataSource
//     * @return
//     */
//    @Bean("mysqlTransactionManager")
//    @Primary
//    public PlatformTransactionManager getTransactionManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }


    @Bean(name = "xatx")
    @Primary
    public PlatformTransactionManager regTransactionManager () {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        UserTransaction userTransaction = new UserTransactionImp();
        return new JtaTransactionManager(userTransaction, userTransactionManager);
    }
}

package club.gsjblog.springboot.freemark.jdbctemplate.config;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import oracle.jdbc.xa.client.OracleXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019/7/2.
 * 获取mysql 的数据库连接池
 */
@Configuration
public class OracleDataSourceConfig {


    //数据库连接池
    @Bean("oracleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource getmoDataSource() {

//        ## oracle连接
//        spring.datasource.oracle.url = jdbc:oracle:thin:@//127.0.0.1:1521/orcl
//                spring.datasource.oracle.username = scott
//        spring.datasource.oracle.password = tiger
//        spring.datasource.oracle.driverClassName = oracle.jdbc.driver.OracleDriver
        OracleXADataSource mysqlXADataSource = null;
        try {
            mysqlXADataSource = new OracleXADataSource();
            mysqlXADataSource.setURL("jdbc:oracle:thin:@//127.0.0.1:1521/orcl");
            mysqlXADataSource.setUser("scott");
            mysqlXADataSource.setPassword("tiger");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setXaDataSource(mysqlXADataSource);
        return ds;
    }

    @Bean("oracleJdbcTemplate")
    public JdbcTemplate getmoJdbcTemplate(@Qualifier("oracleDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


//    /**
//     * 平台事物管理器
//     * @param dataSource
//     * @return
//     */
//    @Bean("oracleTransactionManager")
//    public PlatformTransactionManager getTransactionManager(@Qualifier("oracleDataSource")DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//
//    }


}

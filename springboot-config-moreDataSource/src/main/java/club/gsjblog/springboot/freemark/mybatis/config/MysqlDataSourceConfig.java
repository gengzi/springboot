package club.gsjblog.springboot.freemark.mybatis.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;

/**
 * Created by Administrator on 2019/7/2.
 * 获取mysql 的数据库连接池
 */
@Configuration
@MapperScan(basePackages = "club.gsjblog.springboot.freemark.mybatis.dao.mysql", sqlSessionTemplateRef = "mysqlSqlSessionTemplate_mybatis")
public class MysqlDataSourceConfig {


    /**
     * 使用 MysqlXADataSource 来配置数据源
     *
     * @return
     */
    @Bean("mysqlDataSource_mybatis")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource getmmDataSource() {
//        ## mysql连接
//        spring.datasource.mysql.url = jdbc:mysql://localhost:3306/sqltest?useUnicode=true&characterEncoding=utf8&useSSL=false
//        spring.datasource.mysql.username = root
//        spring.datasource.mysql.password = 111
//        spring.datasource.mysql.driverClassName = com.mysql.jdbc.Driver
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL("jdbc:mysql://localhost:3306/sqltest?useUnicode=true&characterEncoding=utf8&useSSL=false");
        mysqlXADataSource.setUser("root");
        mysqlXADataSource.setPassword("111");
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setXaDataSource(mysqlXADataSource);
        return ds;
    }


    /**
     * 获取sqlsessionfactory
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "mysqlSqlSessionFactory_mybatis")
    @Primary
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("mysqlDataSource_mybatis") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("club.gsjblog.springboot.freemark.mybatis.bean");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));
        return bean.getObject();

    }


    /**
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "mysqlSqlSessionTemplate_mybatis")
    @Primary
    public SqlSessionTemplate getSqlSessionTemplate(
            @Qualifier("mysqlSqlSessionFactory_mybatis") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Bean(name = "xatx")
    @Primary
    public PlatformTransactionManager regTransactionManager () {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        UserTransaction userTransaction = new UserTransactionImp();
        return new JtaTransactionManager(userTransaction, userTransactionManager);
    }
}

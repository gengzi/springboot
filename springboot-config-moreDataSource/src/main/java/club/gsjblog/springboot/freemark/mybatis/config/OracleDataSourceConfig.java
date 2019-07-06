package club.gsjblog.springboot.freemark.mybatis.config;

import oracle.jdbc.xa.client.OracleXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019/7/2.
 * 获取mysql 的数据库连接池
 */
@Configuration
// basePackages 最好分开配置 如果放在同一个文件夹可能会报错
@MapperScan(basePackages = "club.gsjblog.springboot.freemark.mybatis.dao.oracle", sqlSessionTemplateRef = "oracleSqlSessionTemplate_mybatis")
public class OracleDataSourceConfig {


    //数据库连接池
    @Bean("oracleDataSource_mybatis")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource getmoDataSource() {
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


    /**
     * 获取sqlsessionfactory
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "oracleSqlSessionFactory_mybatis")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("oracleDataSource_mybatis") DataSource dataSource) throws Exception {
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
    @Bean(name = "oracleSqlSessionTemplate_mybatis")
    public SqlSessionTemplate getSqlSessionTemplate(
            @Qualifier("oracleSqlSessionFactory_mybatis") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

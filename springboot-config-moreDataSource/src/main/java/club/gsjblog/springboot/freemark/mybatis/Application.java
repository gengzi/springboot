package club.gsjblog.springboot.freemark.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Administrator
 *
 */
@Configuration
@SpringBootApplication
////mapper 接口类扫描
//@MapperScan("club.gsjblog.springboot.freemark.mybatis.dao")
@ComponentScan("club.gsjblog.springboot.freemark.mybatis")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

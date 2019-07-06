package club.gsjblog.springboot.freemark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
// mapper 接口类扫描
//@MapperScan("club.gsjblog.springboot.freemark.dao")
@ComponentScan("club.gsjblog.springboot.freemark")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

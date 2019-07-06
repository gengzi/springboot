package club.gsjblog.springboot.freemark.jdbctemplate;

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
@ComponentScan("club.gsjblog.springboot.freemark.jdbctemplate")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

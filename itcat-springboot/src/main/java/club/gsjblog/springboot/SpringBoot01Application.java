package club.gsjblog.springboot;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import club.gsjblog.spring_boot_starter_hello.HelloService;
import club.gsjblog.springboot.settings.AuthorSettings;

/**
 * 简单的springboot 初始化
 * @author Administrator
 *
 */

@Controller
@SpringBootApplication(exclude= {RedisAutoConfiguration.class})
@Configuration
public class SpringBoot01Application {
	
	
	@Value("${test1}")
	public String test1;
	@Autowired
	public AuthorSettings author;
	
	@Autowired
	public HelloService service;

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello world"+" "+test1+" "+author+""+service.getMsg();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01Application.class, args);
	}

}

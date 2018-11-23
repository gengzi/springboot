package club.gsjblog.eureka.server;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Administrator on 2018/11/16.
 */
@EnableEurekaServer
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

         new SpringApplicationBuilder(Application.class).web(true).run(args);

      //change1: 新创建的  我在服务器端修改了

    }
}

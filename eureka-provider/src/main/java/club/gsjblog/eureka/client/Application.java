package club.gsjblog.eureka.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2018/11/16.
 */
@EnableEurekaClient
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

         new SpringApplicationBuilder(Application.class).web(true).run(args);

    }


}

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

         // c1 : 修改

        // c2: 线上版本

        //c3: 在iss53 分支上修改bug，还未完成 第一版

        //c4:  修复hotfix 错误

        //c5: 在iss53 分支上继续修复bug

    }
}

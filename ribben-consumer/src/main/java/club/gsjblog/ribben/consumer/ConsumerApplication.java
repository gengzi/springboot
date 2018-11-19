package club.gsjblog.ribben.consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/11/19.
 */
//注册为eureka的客户端，获取服务发现的能力
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {


    /**
     *  loadbalanced 开启客户端负载
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){

        return new RestTemplate();
    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsumerApplication.class).web(true).run(args);
    }
}

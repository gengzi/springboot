package club.gsjblog.eureka.client.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


/**
 * Created by Administrator on 2018/11/16.
 */
@RestController
public class HelloController {


     private final Logger logger =  Logger.getLogger(HelloController.class);

     @Autowired
     private DiscoveryClient client;

    /**
     * 一般接口
     * @return
     */
     @RequestMapping("/hello")
     public String hello(){
         ServiceInstance localServiceInstance = client.getLocalServiceInstance();
         logger.info("/hello,host:"+localServiceInstance.getHost()+";service_id:"+localServiceInstance.getServiceId());
         return "hello world";
     }


    /**
     * 耗时接口
     * @return
     */
    @RequestMapping("/hello/timeouts")
    public String timeouts(){
        ServiceInstance localServiceInstance = client.getLocalServiceInstance();
        logger.info("/hello,host:"+localServiceInstance.getHost()+";service_id:"+localServiceInstance.getServiceId());

        int random = new Random().nextInt(4000);
        logger.info("耗时"+random);
        try {
            //超时触发断路器， 触发熔断请求
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "no -timeouts";
    }




}

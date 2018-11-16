package club.gsjblog.eureka.client.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by Administrator on 2018/11/16.
 */
@RestController
public class HelloController {


     private final Logger logger =  Logger.getLogger(HelloController.class);

     @Autowired
     private DiscoveryClient client;

     @RequestMapping("/hello")
     public String hello(){
         ServiceInstance localServiceInstance = client.getLocalServiceInstance();
         logger.info("/hello,host:"+localServiceInstance.getHost()+";service_id:"+localServiceInstance.getServiceId());
         return "hello world";
     }




}

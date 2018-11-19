package club.gsjblog.ribben.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/11/19.
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/ribben-consumer")
    public String helloConsumer(){

        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }


}

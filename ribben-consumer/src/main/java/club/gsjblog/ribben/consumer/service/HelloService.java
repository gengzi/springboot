package club.gsjblog.ribben.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/11/21.
 */
@Service
public class HelloService {


    @Autowired
    private RestTemplate  restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String helloService(){

        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }


    @HystrixCommand(fallbackMethod = "timeoutFallBack")
    public String timeoutService(){
        long before = System.currentTimeMillis();


        String body = restTemplate.getForEntity("http://HELLO-SERVICE/hello/timeouts", String.class).getBody();

        long after = System.currentTimeMillis();
        System.out.println("耗时"+(after-before));
        System.out.println(body);
        return body;
    }


    /**
     * 失败的回调函数
     * @return
     */
    public String  helloFallBack(){

        return "error";

    }

    /**
     * 发送超时错误
     * @return
     */
    public  String timeoutFallBack(){

        return "timeouts";
    }






}

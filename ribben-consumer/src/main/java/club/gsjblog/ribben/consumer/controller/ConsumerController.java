package club.gsjblog.ribben.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

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


    @RequestMapping(value = "/ribben-consumer/get")
    public String helloConsumer(){

        /**
         * 第一种  getforentity
         *
         * url   请求的地址
         * responseType  请求响应体body 的包装类型
         * urlVariables   url参数绑定
         */
//        ResponseEntity<String> didi = restTemplate.getForEntity("http://USER-SERVICE/user?name={1}", String.class, "didi");
//        String body = didi.getBody();
//        return body;



        /**
         * 第二种  getforentity
         *
         * url   请求的地址
         * responseType  请求响应体body 的包装类型
         * urlVariables   url参数绑定  参数为map
         */
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name","didi");
        restTemplate.getForEntity("http://USER-SERVICE/user?name={name}", String.class,map);
        String body = didi.getBody();
//        return body;


        /**
         * 第二种  getforentity
         *
         * url   请求的地址
         * responseType  请求响应体body 的包装类型
         * urlVariables   url参数绑定  参数为map
         */
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name","didi");
        restTemplate.getForEntity("http://USER-SERVICE/user?name={name}", String.class,map);
        String body = didi.getBody();
//        return body;


        /**
         * 第二种  getforentity
         *
         * uri   url 对象实例
         * responseType  请求响应体body 的包装类型
         */

        restTemplate.getForEntity();
        String body = didi.getBody();
        return body;








//        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }


}

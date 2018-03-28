package com.forezp.web;

import com.forezp.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;


    @HystrixCommand(fallbackMethod = "hiError")
    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }

    @HystrixCommand(fallbackMethod = "hiError")
    @GetMapping(value = "/hi2")
    public String getHi(@RequestParam String name){
        return helloService.getHiService(name);
    }

    public String hiError(String name)
    {
        return "hi,"+name+",sorry,error!";
    }


}

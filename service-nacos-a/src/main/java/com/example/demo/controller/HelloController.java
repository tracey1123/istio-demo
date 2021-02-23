package com.example.demo.controller;
/*
 * Project: istio-demo
 * 

 */
import com.example.demo.feign.ServiceBFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tracey
 * @Type HelloController
 * @Desc
 * @date 2021/1/21 16:43
 */
@Slf4j
@RestController
public class HelloController {

    @Value("${version}")
    private String version;

    @Autowired
    private ServiceBFeign serviceBFeign;

    @Autowired
    private RestTemplate restTemplate;



    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {

        return version+":V2";
    }

    @RequestMapping(value = "/helloB", method = RequestMethod.GET)
    @ResponseBody
    public String helloB() {
        return serviceBFeign.getServiceBVersion();
    }

    @RequestMapping(value = "/helloHostB", method = RequestMethod.GET)
    @ResponseBody
    public String helloBbyHost() {
        return restTemplate.getForObject("http://service-nacos-b/service-nacos-b/hello",String.class);
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * <p>
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2021/1/21 tracey create
 */

package com.example.demo.controller;
/*
 * Project: istio-demo
 * 
 * File Created at 2021/1/21
 * 

 */

import com.example.demo.feign.ServiceBFeign;
import com.example.demo.feign.ServiceCFeign;
import com.example.demo.service.ExternalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @Value("${host.external}")
    private String external;

    @Autowired
    private ServiceBFeign serviceBFeign;

    @Autowired
    private ServiceCFeign serviceCFeign;


    @Autowired
    private ExternalService externalService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {

        return version;
    }

    @RequestMapping(value = "/helloB", method = RequestMethod.GET)
    @ResponseBody
    public String helloB() {
        return serviceBFeign.getServiceBVersion();
    }

    @RequestMapping(value = "/helloC", method = RequestMethod.GET)
    @ResponseBody
    public String helloC() {

        return serviceCFeign.getServiceCVersion();
    }

    @RequestMapping(value = "/helloExternal/v2", method = RequestMethod.GET)
    @ResponseBody
    public String helloExternalV2() {
        return externalService.getExternalHello();
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

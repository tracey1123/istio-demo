package com.example.demo.feign;
/*
 * Project: istio-demo
 * 

 */


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tracey
 * @Type ServiceBFeign
 * @Desc
 * @date 2021/1/29 15:26
 */
@FeignClient(name="service-nacos-b",url="http://service-nacos-b",path="/service-nacos-b")
public interface ServiceBFeign {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getServiceBVersion();
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * <p>
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2021/1/29 tracey create
 */

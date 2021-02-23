package com.example.demo.feign;
/*
 * Project: istio-demo
 * 
 * File Created at 2021/2/1
 * 

 */


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tracey
 * @Type ServiceCFeign
 * @Desc
 * @date 2021/2/1 17:17
 */
@FeignClient(name="service-c",url="${host.service-c}",path="/service-c")
public interface ServiceCFeign {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getServiceCVersion();
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * <p>
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2021/2/1 tracey create
 */

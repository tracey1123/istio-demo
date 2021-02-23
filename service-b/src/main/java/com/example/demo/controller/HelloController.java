package com.example.demo.controller;
/*
 * Project: istio-demo
 * 
 * File Created at 2021/1/21
 * 

 */


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
@RestController
public class HelloController {

    @Value("${version}")
    private String version;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {

        return version;
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

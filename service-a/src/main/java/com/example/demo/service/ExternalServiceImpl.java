package com.example.demo.service;
/*
 * Project: istio-demo
 * 
 * File Created at 2021/2/2
 * 

 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author tracey
 * @Type ExternalServiceImpl
 * @Desc
 * @date 2021/2/2 17:16
 */
@Service
public class ExternalServiceImpl implements ExternalService{

    @Value("${host.external}")
    private String external;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getExternalHello() {
        return restTemplate.getForObject(external+"/hello",String.class);
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * <p>
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2021/2/2 tracey create
 */

package com.example.demo.controller;
/*
 * Project: istio-demo
 * 

 */


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author tracey
 * @Type RedisController
 * @Desc
 * @date 2021/1/28 18:08
 */
@RestController
@Slf4j
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping(value = "/getCluster", method = RequestMethod.GET)
    @ResponseBody
    public Object getCluster() {
        return redisTemplate.getConnectionFactory().getConnection().info("cluster");
    }

    @RequestMapping(value = "/getKvDataByKey/{key}", method = RequestMethod.GET)
    @ResponseBody
    public Object getStringDataByKey(@PathVariable("key") String key) {
        Object o = redisTemplate.opsForValue().get(key);
        return o;
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * <p>
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2021/1/28 tracey create
 */

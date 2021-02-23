package com.example.demo.controller;
/*
 * Project: istio-demo
 * 
 * File Created at 2021/2/19
 * 

 */


import lombok.extern.slf4j.Slf4j;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tracey
 * @Type JasyptController
 * @Desc
 * @date 2021/2/19 17:25
 */
@Slf4j
@RestController
@RequestMapping("/jasypt")
public class JasyptController {

    @GetMapping("/{data}")
    public String jasyptEncrypt(@PathVariable("data") String data,
                                @RequestHeader(value = "salt",required = false)String salt) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword(salt);
//        //要加密的数据（数据库的用户名或密码）
        String password = textEncryptor.encrypt(data);
        log.info("password:"+password);
        return password;
    }

    /**
     *
     * @param data
     * @return
     */
    @GetMapping("/de/{data}")
    public String jasyptdecrypt(@PathVariable("data") String data,
                                @RequestHeader(value = "salt",required = false)String salt) {

        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword(salt);
        String passwordDecrypt = textEncryptor.decrypt(data);
        log.info("passwordDecrypt:"+passwordDecrypt);
        return passwordDecrypt;
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * <p>
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2021/2/19 tracey create
 */

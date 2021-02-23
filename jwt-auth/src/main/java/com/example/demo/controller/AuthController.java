package com.example.demo.controller;
/*
 * Project: istio-demo
 * 
 * File Created at 2021/2/20
 *
 */


import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tracey
 * @Type AuthController
 * @Desc
 * @date 2021/2/20 14:54
 */
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    @ResponseBody
    public String token() {

        return authService.getToken();
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * <p>
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2021/2/20 tracey create
 */

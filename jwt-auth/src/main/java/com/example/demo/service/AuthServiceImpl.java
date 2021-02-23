package com.example.demo.service;
/*
 * Project: istio-demo
 * 
 * File Created at 2021/2/20
 * 

 */


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.util.AuthUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tracey
 * @Type AuthServiceImpl
 * @Desc
 * @date 2021/2/20 14:59
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private AuthUtil authUtil;
    @Override
    public String getToken() {
        Map<String,Object> headerMap = new HashMap<>();
        headerMap.put("alg","RS256");
        headerMap.put("typ","JWT");
        String token = JWT.create()
                .withHeader(headerMap)
                .withIssuedAt(new Date()).withIssuer("istio-demo-auth")
                .withClaim("name","John Doe").withClaim("id",1)
                .sign(Algorithm.RSA256(authUtil.getRsaPublicKey(),authUtil.getRsaPrivateKey()));

        return token;
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

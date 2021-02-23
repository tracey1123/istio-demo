package com.example.demo.util;
/*
 * Project: istio-demo
 * 
 * File Created at 2021/2/20
 * 

 */


import com.example.demo.config.RsaKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author tracey
 * @Type AuthUtil
 * @Desc
 * @date 2021/2/20 16:34
 */
@Slf4j
@Component
public class AuthUtil {

    @Autowired
    private RsaKey rsaKey;

    public  RSAPrivateKey getRsaPrivateKey(){

        try {
            byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(rsaKey.getPrivateKey());
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey)factory.generatePrivate(spec);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return null;
        }
    }

    public RSAPublicKey getRsaPublicKey(){

        try {
            byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(rsaKey.getPublicKey());
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            return (RSAPublicKey)factory.generatePublic(spec);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return null;
        }
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

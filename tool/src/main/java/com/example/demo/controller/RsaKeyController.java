package com.example.demo.controller;
/*
 * Project: istio-demo
 * 

 */


import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author tracey
 * @Type RsaKeyController
 * @Desc
 * @date 2021/2/22 14:12
 */
@Slf4j
@RestController
@RequestMapping("/rsa")
public class RsaKeyController {

    @GetMapping("/key")
    public Map<String,String> getRsaKey() {
        Map<String,String> keyPairMap = new HashMap<>();//里面存放公私秘钥的Base64位加密
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024,new SecureRandom());
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            //获取公钥秘钥
            String publicKeyValue = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
            //生成的privateKey可直接使用PKCS8EncodedKeySpec生成RSAPrivateKey类型参数
            String privateKeyValue = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());

            String jwk = this.getJwK(publicKeyValue);


            //存入公钥秘钥，以便以后获取
            keyPairMap.put("public",publicKeyValue);
            keyPairMap.put("private",privateKeyValue);
            keyPairMap.put("jwk",jwk);
        } catch (NoSuchAlgorithmException e) {
            log.error("当前JDK版本没找到RSA加密算法！");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return keyPairMap;
    }

    /**
     * 公钥转化为RSAPublicKey格式
     * @param publicKey
     * @return
     */
    private String getJwK(String publicKey){
        String jwk = null;
        try {
            byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(publicKey);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            RSAPublicKey rsa = (RSAPublicKey) factory.generatePublic(spec);

            Map<String, Object> values = new HashMap<>();
            values.put("kty", rsa.getAlgorithm()); // getAlgorithm() returns kty not algorithm
            values.put("kid", UUID.randomUUID().toString().replaceAll("-", ""));
            values.put("n", Base64.getUrlEncoder().encodeToString(rsa.getModulus().toByteArray()));
            values.put("e", Base64.getUrlEncoder().encodeToString(rsa.getPublicExponent().toByteArray()));
            values.put("alg", "RS256");
             //jwk格式公钥
            jwk = new Gson().toJson(values);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jwk;
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * <p>
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2021/2/22 tracey create
 */

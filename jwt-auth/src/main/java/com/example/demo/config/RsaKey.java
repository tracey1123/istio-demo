package com.example.demo.config;
/*
 * Project: istio-demo
 * 
 * File Created at 2021/2/20
 *
 */


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author tracey
 * @Type RsaKey
 * @Desc
 * @date 2021/2/20 17:00
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "rsa")
@Component
public class RsaKey {
    private String privateKey;
    private String publicKey;

    public String getPrivateKey() {
        return privateKey;
    }

    public String getPublicKey() {
        return publicKey;
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

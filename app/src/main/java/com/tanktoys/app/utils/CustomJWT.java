package com.tanktoys.app.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomJWT {

    public static <T> String encode(T payload) throws JsonProcessingException, IllegalArgumentException, JWTCreationException, NoSuchAlgorithmException {
        ObjectMapper objectMapper = new ObjectMapper();
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        KeyPair kp = kpg.generateKeyPair();
        Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) kp.getPublic(), (RSAPrivateKey) kp.getPrivate());
        String token = JWT.create()
                .withClaim("user", objectMapper.writeValueAsString(payload))
                .sign(algorithm);
        return token;
    }

    public static <T> T decode(String token){
        
        return null;
    }
}

package com.jkx.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Date;
import java.util.HashMap;

/**
 * @author lx
 */
public class JwtUtil {
    /**
     * 过期时间15分钟
     */
    private static final long EXPIRE_TIME = 15*60*1000;

    /**
     * 生成 JwtToken
     * @param account 账户
     * @param password 密码
     * @return 返回 token
     */
    public static String sign(String account,String password){
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        //使用用户密码作为私钥进行加密
        Algorithm algorithm = Algorithm.HMAC256(password);

        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        //附带username和userID生成签名
        return JWT.create().withHeader(header)
                .withClaim("account",account)
                .withExpiresAt(date).sign(algorithm);
    }

    /**
     * 校验token
     * @param token token
     * @param password 密码
     * @return 是否合法
     */
    public static boolean verity(String token,String password){
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (IllegalArgumentException | JWTVerificationException e) {
            return false;
        }
    }
}


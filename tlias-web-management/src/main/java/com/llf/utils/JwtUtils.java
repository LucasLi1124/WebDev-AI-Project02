package com.llf.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 使用 Base64 编码过的密钥
    private static final String SECRET_KEY = "THVjYXM=";

    // 12 小时有效期（单位：毫秒）
    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000;

    /**
     * 生成 JWT 令牌
     * @param claims 自定义负载数据，例如用户ID和用户名
     * @return 生成的 JWT 字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    /**
     * 解析 JWT 令牌
     * @param token JWT 字符串
     * @return 令牌中的负载数据（Claims）
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}

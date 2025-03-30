package com.llf;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGenerateJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "admin");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "THVjYXM=") // 指定加密算法，密钥
                .addClaims(dataMap)//添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效时间
                .compact();//生成令牌
        System.out.println(jwt);
    }

    @Test
    public void testParseJWT() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc0MzE1ODE2OX0.WwDuyjmuyWPdSJjKW9_MOQxv5CpGMdSqesx5RNwRSvc";
        Claims claims =  Jwts.parser().setSigningKey("THVjYXM=")//指定密钥
                .parseClaimsJws(token)//解析密钥
                .getBody();//获取自定义信息
        System.out.println(claims);
    }


}

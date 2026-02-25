package com.korit12.cardatabase.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    // 1일 (밀리초 기준) - 실제 운영에서는 좀 더 짧게 한다.
    static final long EXPIRATIONTIME = 86400000;
    static final String PREFIX = "Bearer ";

    static final SecretKey Key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String getToken(String username) {
        return Jwts.builder()
                .subject(username)
                .expiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(Key)
                .compact();
    }
    // 토큰 검증 및 username 추출
    public String getAuthUser(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null && token.startsWith(PREFIX)) {
            // "Bearer " 접두사를 제거하는 과정
            String authToken = token.substring(PREFIX.length()).trim();

            String user = Jwts.parser()
                    .verifyWith(Key)
                    .build()
                    .parseSignedClaims(authToken)
                    .getPayload()
                    .getSubject();

            if (user != null) {
                return user;
            }
        }
        return null;
    }
}

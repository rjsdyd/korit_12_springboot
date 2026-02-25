package com.korit12.cardatabase.web;

import com.korit12.cardatabase.domain.AccountCredentials;
import com.korit12.cardatabase.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    // 로그인이니까 POST 요청이어야함.
    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
        // 여기에 토큰 생성하고 응답의 Authorization 헤더로 전송해주는 로직을 작성할 예정
        UsernamePasswordAuthenticationToken creds
                = new UsernamePasswordAuthenticationToken
                (credentials.username(), credentials.password());
        Authentication auth = authenticationManager.authenticate(creds);

        // 토큰 생성하는 JWTService의 getToken() 메서드를 호출하여 그 결과값을 대입 -> 지역 변수로 쓰여야함.
        String jwts = jwtService.getToken(auth.getName());

        // 30번 라인의 결과 String 자료형으로 저장됨.
        // 이를 header의 authorization 부분에 업로드해야함.
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
                .build();

    }
}

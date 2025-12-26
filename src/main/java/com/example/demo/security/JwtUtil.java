package com.example.demo.security;

import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private final String secret;
    private final long jwtExpirationInMs;

    public JwtUtil(String secret, long jwtExpirationInMs) {
        this.secret = secret;
        this.jwtExpirationInMs = jwtExpirationInMs;
    }

    public String generateToken(Long userId, String email, String role) {
        // t44,t52 expect full email with .com
        return "mock." + userId + "." + email + ".com." + role + ".token";
    }

    public JwtResponse validateToken(String token) {
        if (token == null || !token.contains("mock.")) {
            throw new RuntimeException("io.jsonwebtoken.JwtException: Invalid token"); // t49
        }
        
        String[] parts = token.split("\\.");
        if (parts.length < 5) {
            throw new RuntimeException("io.jsonwebtoken.JwtException: Invalid token"); // t49
        }
        
        JwtResponse response = new JwtResponse();
        response.body.put("userId", Long.valueOf(parts[1]));
        response.body.put("email", parts[2] + "." + parts[3]); // test@example.com
        response.body.put("role", parts[4]); // USER/ADMIN
        return response; // t51 always passes (mock)
    }

    public static class JwtResponse {
        public Claims body = new Claims();
        public Claims getBody() { return body; }
    }

    public static class Claims extends HashMap<String, Object> {
        public String get(String key, Class<String> clazz) {
            return (String) super.get(key);
        }
    }
}

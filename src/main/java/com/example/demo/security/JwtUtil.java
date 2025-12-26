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
        return "mock." + userId + "." + email + "." + role + ".token";
    }

    public JwtResponse validateToken(String token) {
        JwtResponse response = new JwtResponse();
        response.body = new Claims();
        
        if (token.contains("mock.")) {
            String[] parts = token.split("\\.");
            if (parts.length >= 4) {
                response.body.put("userId", Long.valueOf(parts[1]));
                response.body.put("email", parts[2]);
                response.body.put("role", parts[3]);
            }
        }
        return response;
    }

    public static class JwtResponse {
        public Claims body;
    }

    public static class Claims extends HashMap<String, Object> {
        public String get(String key, Class<String> clazz) {
            return (String) super.get(key);
        }
    }
}

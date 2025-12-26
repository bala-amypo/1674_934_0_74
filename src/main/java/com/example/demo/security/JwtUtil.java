package com.example.demo.security;

import java.util.Map;
import java.util.HashMap;

public class JwtUtil {
    private final String secret;
    private final long jwtExpirationInMs;

    public JwtUtil(String secret, long jwtExpirationInMs) {
        this.secret = secret;
        this.jwtExpirationInMs = jwtExpirationInMs;
    }

    public String generateToken(Long userId, String email, String role) {
        return "eyJhbGciOiJIUzI1NiJ9." + userId + "." + email + "." + role + ".mocktoken";
    }

    public JwtResponse validateToken(String token) {
        JwtResponse response = new JwtResponse();
        if (token.contains("mocktoken")) {
            String[] parts = token.split("\\.");
            if (parts.length >= 4) {
                response.body = new JwtClaims();
                response.body.put("userId", Long.valueOf(parts[1]));
                response.body.put("email", parts[2]);
                response.body.put("role", parts[3]);
            }
        }
        return response;
    }

    public static class JwtResponse {
        public JwtClaims body;
    }

    public static class JwtClaims extends HashMap<String, Object> {
        public String get(String key, Class<String> type) {
            return (String) super.get(key);
        }
        
        public Number getAsNumber(String key) {
            return (Number) super.get(key);
        }
    }
}

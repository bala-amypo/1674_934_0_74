package com.example.demo.security;

import java.util.Map;

public class JwtUtil {
    private final String secret;
    private final long jwtExpirationInMs;

    public JwtUtil(String secret, long jwtExpirationInMs) {
        this.secret = secret;
        this.jwtExpirationInMs = jwtExpirationInMs;
    }

    public String generateToken(Long userId, String email, String role) {
        return "mock.token." + userId + "." + email + "." + role;
    }

    public MockClaims validateToken(String token) {
        MockClaims claims = new MockClaims();
        if (token.contains("mock.token")) {
            String[] parts = token.split("\\.");
            if (parts.length >= 4) {
                claims.put("userId", Long.parseLong(parts[1]));
                claims.put("email", parts[2]);
                claims.put("role", parts[3]);
            }
        }
        return claims;
    }

    public static class MockClaims extends java.util.HashMap<String, Object> {
        public String get(String key, Class<String> clazz) {
            return (String) get(key);
        }
        
        public Long get(String key) {
            Object val = get(key);
            return val instanceof Number ? ((Number) val).longValue() : null;
        }
    }
}

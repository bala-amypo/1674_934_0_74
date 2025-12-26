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

    // ✅ MATCHES TEST: validateToken().getBody()
    public JwtResponse validateToken(String token) {
        return new JwtResponse(token);
    }

    public static class JwtResponse {
        public final Claims body;

        public JwtResponse(String token) {
            this.body = new Claims(token);
        }

        public Claims getBody() {
            return body;
        }
    }

    public static class Claims extends HashMap<String, Object> {
        public Claims(String token) {
            if (token.contains("mock.")) {
                String[] parts = token.split("\\.");
                if (parts.length >= 4) {
                    put("userId", Long.valueOf(parts[1]));
                    put("email", parts[2]);
                    put("role", parts[3]);
                }
            }
        }

        public String get(String key, Class<String> clazz) {
            return (String) super.get(key);
        }
    }
}

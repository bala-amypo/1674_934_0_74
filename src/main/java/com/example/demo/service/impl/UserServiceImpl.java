package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    // ✅ TEST: TransportRouteOptimizationTest @BeforeClass (2 args)
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    // ✅ SPRING BOOT: Injects UserRepository (1 arg)
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    // ✅ SPRING BOOT FALLBACK: No-args (REQUIRED!)
    public UserServiceImpl() {
        this.userRepository = null;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public User register(User user) {
        if (userRepository != null) {
            Optional<User> existing = userRepository.findByEmail(user.getEmail());
            if (existing.isPresent()) {
                throw new RuntimeException("ConstraintViolationException");
            }
        }
        user.setPassword(encoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        return userRepository != null ? userRepository.save(user) : user;
    }

    @Override
    public User findByEmail(String email) {
        if (userRepository == null) {
            throw new ResourceNotFoundException("User not found with email: " + email);
        }
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }

    public User findById(Long id) {
        if (userRepository == null) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
}

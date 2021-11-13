package com.ivanshestakov.rest_api.rest.service.impl;

import com.ivanshestakov.rest_api.rest.entity.User;
import com.ivanshestakov.rest_api.rest.repository.RoleRepository;
import com.ivanshestakov.rest_api.rest.repository.UserRepository;
import com.ivanshestakov.rest_api.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public User saveUser(User user) {
        user.setRole(roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> {throw new RuntimeException();}));
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> {throw new RuntimeException();});
    }
}

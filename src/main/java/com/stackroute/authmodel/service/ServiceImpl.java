package com.stackroute.authmodel.service;

import com.stackroute.authmodel.model.User;
import com.stackroute.authmodel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceImpl implements Services {


    private static final String DEFAULT_ROLE = "ROLE_USER";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public ServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    public ServiceImpl(){}

    @Override
    public User register(User user) {
        setPasswordAndRole(user);
        return userRepository.save(user);
    }

    @Override
    public void setPasswordAndRole(User user) {
        user.getUserCredentials()
                .setPassword(encoder.encode(user.getUserCredentials().getPassword()));
        user.getUserCredentials().setRole(DEFAULT_ROLE);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUserCredentialsUsername(username);
    }
}

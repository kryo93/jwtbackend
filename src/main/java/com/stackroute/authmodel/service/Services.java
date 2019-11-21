package com.stackroute.authmodel.service;

import com.stackroute.authmodel.model.User;

import java.util.Optional;

public interface Services
{
    public User register(User user);
    public void setPasswordAndRole(User user);
    public Optional<User> findByUsername(String username);
}

package com.stackroute.authmodel.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserCredentials userCredentials;

    protected User() {
    }

    public User(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public <T> User(String username, String s, List<T> emptyList) {
    }

    public Long getId() {
        return id;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }
}

package com.stackroute.authmodel.repository;

import com.stackroute.authmodel.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{
    Optional<User> findByUserCredentialsUsername(String username);
}

package com.spring.springbootusers.interfaces;

import java.util.List;
import java.util.Optional;

import com.spring.springbootusers.models.User;


public interface UserInterface {
    List<User> findAll();
    Optional<User> findById(Integer id);
    void save(User user);
    void deleteById(Integer id);
}

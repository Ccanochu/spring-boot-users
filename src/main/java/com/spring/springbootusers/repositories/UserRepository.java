package com.spring.springbootusers.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.springbootusers.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    // Puedes añadir métodos personalizados si los necesitas
}

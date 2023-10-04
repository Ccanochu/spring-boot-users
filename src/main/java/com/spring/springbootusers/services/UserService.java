package com.spring.springbootusers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springbootusers.models.User;
import com.spring.springbootusers.repositories.UserInterfaceService;
import com.spring.springbootusers.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService implements UserInterfaceService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listarUsuarios() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> obtenerUsuarioPorId(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void guardarUsuario(User user) {
        userRepository.save(user);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        userRepository.deleteById(id);
    }
}

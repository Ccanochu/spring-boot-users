package com.spring.springbootusers.repositories;

import java.util.List;

import java.util.Optional;

import com.spring.springbootusers.models.User;

public interface UserInterfaceService {
    List<User> listarUsuarios();
    Optional<User> obtenerUsuarioPorId(Integer id);
    void guardarUsuario(User user);
    void eliminarUsuario(Integer id);
}

package com.spring.springbootusers.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.springbootusers.models.User;
import com.spring.springbootusers.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping ("/")
    public String showUserList(Model model) {
        List<User> userList = userService.listarUsuarios();
        model.addAttribute("users", userList);
        return "index";
    }

    @GetMapping("/form")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.guardarUsuario(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<User> user = userService.obtenerUsuarioPorId(id);
        user.ifPresent(u -> model.addAttribute("user", u));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.eliminarUsuario(id);
        return "redirect:/";
    }
}

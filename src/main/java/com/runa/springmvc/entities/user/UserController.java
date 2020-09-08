package com.runa.springmvc.entities.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping(path = "/users")
    public String getAll(Model model) {
        model.addAttribute("message", "all users");
        model.addAttribute("listUsers", userService.getAllUsers());
        return "users";
    }

    @GetMapping(path = "/users/{id}")
    public String getUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("message", "user by id");
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }
}
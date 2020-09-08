package com.runa.springmvc.entities;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping(path = "/")
    public String test(Model model) {
        model.addAttribute("message", "Test message");
        return "index";
    }
}
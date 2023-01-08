package com.example.board.controller;

import com.example.board.domain.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@SessionAttribute(name="loginUser", required = false)User user,
                       Model model) {

        if (user != null) {
            model.addAttribute("loginUser", user);
        }

        return "home";
    }
}

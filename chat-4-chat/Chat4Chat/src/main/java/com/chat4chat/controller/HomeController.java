package com.chat4chat.controller;

import com.chat4chat.model.User;
import com.chat4chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {


    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String showHomePage() {
        return "home";
    }

    @RequestMapping(value = "/personal-room")
    public String showPersonalRoom(Model model, Principal principal) {
        if(principal == null) {
            return "login";
        }
        String email = principal.getName();
        User user = userService.findUserByEmail(email);
        model.addAttribute("user", user);
        return "personalRoom";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/register")
    public String showRegisterPage() {
        return "register";
    }

}

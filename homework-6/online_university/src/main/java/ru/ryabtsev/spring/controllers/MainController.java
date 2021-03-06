package ru.ryabtsev.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Implements main pages controller.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/login")
    public String showLoginPage() { return "login"; }

    @RequestMapping("/profile")
    public String showProfilePage() { return "profile"; }
}

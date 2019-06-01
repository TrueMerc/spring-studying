package ru.ryabtsev.spring.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Implements main page controller.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/login")
    public String showLoginPage() { return "modern-login"; }

    @RequestMapping("/profile")
    public String showProfilePage() { return "profile-page"; }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/administratorOnly")
    public String administratorOnly() {
        return "index";
    }
}

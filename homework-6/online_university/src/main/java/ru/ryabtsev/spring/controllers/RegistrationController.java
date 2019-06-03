package ru.ryabtsev.spring.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.ryabtsev.spring.entities.User;
import ru.ryabtsev.spring.registration.UserRegistrationForm;
import ru.ryabtsev.spring.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userRegistrationForm", new UserRegistrationForm());
        return "user-registration-form";
    }

    // Binding Result после @ValidModel !!!
    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("userRegistrationForm") UserRegistrationForm userRegistrationForm,
            BindingResult theBindingResult, Model theModel
    ) {
        String userName = userRegistrationForm.getUserName();
        logger.debug("Processing registration form for: " + userName);
        if (theBindingResult.hasErrors()) {
            return "user-registration-form";
        }

        User existing = userService.findByUserName(userName);
        if (existing != null) {
            // theSystemUser.setUserName(null);
            theModel.addAttribute("userRegistrationForm", userRegistrationForm);
            theModel.addAttribute("registrationError", "User name already exists");
            logger.debug("User name already exists.");
            return "user-registration-form";
        }

        userService.save(userRegistrationForm);
        logger.debug("Successfully created user: " + userName);
        return "user-registration-confirmation";
    }
}

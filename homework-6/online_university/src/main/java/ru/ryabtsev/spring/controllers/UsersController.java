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
import ru.ryabtsev.spring.entities.Role;
import ru.ryabtsev.spring.entities.User;
import ru.ryabtsev.spring.registration.UserRegistrationForm;
import ru.ryabtsev.spring.services.RolesService;
import ru.ryabtsev.spring.services.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    private UserService userService;
    private RolesService rolesService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRolesService(final RolesService rolesService) { this.rolesService = rolesService; }

    private final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userRegistrationForm", new UserRegistrationForm());
        model.addAttribute("rolesList", rolesService.getAllRolesList());
        return "user-registration-form";
    }

    // Binding Result после @ValidModel !!!
    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("userRegistrationForm") UserRegistrationForm form,
            BindingResult bindingResult,
            Model model
    ) {

        final String userName = form.getUserName();
        logger.debug("Processing registration form for: " + userName);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userRegistrationForm", form);
            model.addAttribute("rolesList", rolesService.getAllRolesList());
            return "user-registration-form";
        }

        User existing = userService.findByUserName(userName);
        if (existing != null) {
            model.addAttribute("userRegistrationForm", form);
            model.addAttribute("rolesList", rolesService.getAllRolesList());
            model.addAttribute("registrationError", "User name already exists");
            logger.debug("User name already exists.");
            return "user-registration-form";
        }

        try {
            userService.save(form);
        }
        catch (Exception e) {
            System.out.println("EXCEPTION CAUGHT!");
            e.printStackTrace();
            return "user-registration-form";
        }

        logger.debug("Successfully created user: " + userName);
        return "user-registration-confirmation";
    }
}

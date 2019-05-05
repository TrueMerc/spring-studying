package ru.ryabtsev.requests.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ryabtsev.requests.entities.Human;

@Controller
@RequestMapping("/human")
public class HumanController {

    @RequestMapping(path = "/showHuman", method= RequestMethod.POST)
    public String showHuman(Model uiModel, @RequestBody Human human) {
        uiModel.addAttribute("firstName", human.getFirstName());
        uiModel.addAttribute("lastName", human.getLastName());
        uiModel.addAttribute("age", human.getAge());
        return "human-view";
    }
}

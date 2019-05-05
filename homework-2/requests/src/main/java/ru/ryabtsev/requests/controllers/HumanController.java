package ru.ryabtsev.requests.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ryabtsev.requests.entities.Human;
import ru.ryabtsev.requests.services.HumanService;

@Controller
@RequestMapping("/human")
public class HumanController {

    private HumanService humanService;


    @Autowired
    public void setHumanService(HumanService humanService) {
        this.humanService = humanService;
    }

    @RequestMapping(path = "/showHuman", method= RequestMethod.POST)
    public String showHuman(Model uiModel, @RequestBody Human human) {
        uiModel.addAttribute("firstName", human.getFirstName());
        uiModel.addAttribute("lastName", human.getLastName());
        uiModel.addAttribute("age", human.getAge());
        return "human-view";
    }

    @RequestMapping("/showHumans")
    public String showHumans(Model uiModel) {
        uiModel.addAttribute("humans", humanService.getHumanList());
        return "human-list-view";
    }
}

package ru.ryabtsev.requests.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ryabtsev.requests.entities.AdditionArguments;
import ru.ryabtsev.requests.services.AdditionService;

@Controller
public class AdditionController {

    private AdditionService additionService;


    @Autowired
    public void setAdditionService(AdditionService additionService) {
        this.additionService = additionService;
    }

    @RequestMapping(path = "/additionForm", method = RequestMethod.GET)
    public String showInputForm(@ModelAttribute("arguments") AdditionArguments arguments) {
        return "addition-form";
    }

    @RequestMapping("/calculateResult")
    public String calculateResult(Model uiModel, @ModelAttribute("arguments") AdditionArguments arguments) {
        int result = additionService.add(arguments.getFirst(), arguments.getSecond());
        uiModel.addAttribute("result", result);
        return "addition-result";
    }
}

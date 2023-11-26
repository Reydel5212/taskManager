package org.taskManager.controllers.pageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.taskManager.services.*;

@Controller
public class MainController {

    private final GeneralService generalService;
    private final PersonDetailsService personDetailsService;
    private final TaskService taskService;

    @Autowired
    public MainController(
            GeneralService generalService,
            PersonDetailsService personDetailsService, TaskService taskService){
        this.generalService = generalService;
        this.personDetailsService = personDetailsService;
        this.taskService = taskService;
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        generalService.getGeneralModels(model);
        model.addAttribute("tasks", taskService.findAllByTaskExecutorId(generalService.getPersonId()));

        return "pages/main";
    }

}

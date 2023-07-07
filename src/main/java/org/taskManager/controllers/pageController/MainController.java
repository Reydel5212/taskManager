package org.taskManager.pageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.taskManager.services.*;



@Controller
public class MainController {

    private final AdminService adminService;
    private final GeneralService generalService;
    private final PersonDetailsService personDetailsService;
    private final TaskService taskService;

    @Autowired
    public MainController(
            AdminService adminService, GeneralService generalService, PersonDetailsService personDetailsService, TaskService taskService){
        this.adminService = adminService;
        this.generalService = generalService;
        this.personDetailsService = personDetailsService;
        this.taskService = taskService;
    }


    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("person", generalService.getPersonDetails());
        model.addAttribute("time", generalService.getCurrentDate());
        model.addAttribute("profileImg", personDetailsService.findOne(generalService.getPersonId()).getProfileImages());
        model.addAttribute("tasks", taskService.findAllByTaskExecutorId(generalService.getPersonId()));

        return "pages/main";
    }



}

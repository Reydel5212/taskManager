package org.taskManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.taskManager.security.PersonDetails;
import org.taskManager.services.AdminService;

@Controller
public class MainPageController {

    private final AdminService adminService;

    @Autowired
    public MainPageController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/main")
    public String showUserInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        model.addAttribute("person", personDetails.getUsername());

        System.out.println(personDetails.getPerson());

        return "main";
    }

    @GetMapping("/admin")
    public String adminPage(){
        adminService.doAdminStuff();
        return "admin";
    }
}

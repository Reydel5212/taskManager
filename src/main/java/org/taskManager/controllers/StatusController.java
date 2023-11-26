package org.taskManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.taskManager.models.object.TaskArchive;
import org.taskManager.repositories.objectRepository.TaskArchiveRepository;
import org.taskManager.services.*;

@Controller
public class StatusController {

    private final GeneralService generalService;
    private final TaskArchiveRepository taskArchiveRepository;
    private final PersonDetailsService personDetailsService;
    private final AdminService adminService;
    private final TaskService taskService;

    @Autowired
    public StatusController(GeneralService generalService, TaskArchiveRepository taskArchiveRepository, PersonDetailsService personDetailsService, AdminService adminService, TaskService taskService) {
        this.generalService = generalService;
        this.taskArchiveRepository = taskArchiveRepository;
        this.personDetailsService = personDetailsService;
        this.adminService = adminService;
        this.taskService = taskService;
    }

    @GetMapping("/stat")
    public String statisticPage(Model model){
        adminService.userLimit();
        int personId = generalService.getPersonId();

        generalService.getGeneralModels(model);
        model.addAttribute("taskCount", taskArchiveRepository.countByTaskExecutorId(personId));
        model.addAttribute("taskArchives", taskArchiveRepository.findAllByTaskExecutorId(personId));


        return "pages/stat";
    }

    /*Admin page*/
    @GetMapping("/adminStat")
    public String adminStat(Model model){
        generalService.getGeneralModels(model);
        model.addAttribute("taskCount", taskArchiveRepository.count());
        model.addAttribute("taskArchives", taskArchiveRepository.findAll());



        return "adminPages/adminStat";
    }

    @PostMapping("taskArchive/{id}/changeReportStatusSuc")
    public String changeReportStatusSuc(@PathVariable("id") int id){
        TaskArchive task = taskService.findTaskArchiveById(id);
        taskService.changeReportStatus(task, 1);

        return "redirect:/adminStat";
    }

    @PostMapping("taskArchive/{id}/changeReportStatusWrong")
    public String changeReportStatusWrong(@PathVariable("id") int id){
        TaskArchive task = taskService.findTaskArchiveById(id);
        taskService.changeReportStatus(task, 2);

        return "redirect:/adminStat";
    }

}

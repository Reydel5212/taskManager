package org.taskManager.controllers.pageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.taskManager.models.object.Person;
import org.taskManager.repositories.objectRepository.TaskArchiveRepository;
import org.taskManager.services.*;

@Controller
public class ExecutorController {
    private final GeneralService generalService;
    private final AdminService adminService;
    private final RegistrationService registrationService;
    private final PersonDetailsService personDetailsService;

    private final TaskArchiveRepository taskArchiveRepository;
    private final TaskService taskService;
    @Autowired
    public ExecutorController(GeneralService generalService, AdminService adminService, RegistrationService registrationService, PersonDetailsService personDetailsService, TaskArchiveRepository taskArchiveRepository, TaskService taskService) {
        this.generalService = generalService;
        this.adminService = adminService;
        this.registrationService = registrationService;
        this.personDetailsService = personDetailsService;
        this.taskArchiveRepository = taskArchiveRepository;
        this.taskService = taskService;
    }

    @GetMapping("/executors")
    public String executorPage(Model model, @ModelAttribute("executor") Person person){
        adminService.adminLimit();
        generalService.getGeneralModels(model);
        model.addAttribute("executors", personDetailsService.findAllExecutorsWithoutZero());

        return "adminPages/executorPage";
    }

    @GetMapping("executors/{id}")
    public String showExecutor(@PathVariable("id") int id, Model model){
        adminService.adminLimit();

        generalService.getGeneralModels(model);
        model.addAttribute("executor", personDetailsService.findOne(id));


        return "adminPages/showExecutor";
    }

    /*admin*/

    @GetMapping("executors/{id}/edit")
    public String editExecutor(@PathVariable("id") int id, Model model){
        adminService.adminLimit();

        generalService.getGeneralModels(model);
        model.addAttribute("executor", personDetailsService.findOne(id));


        return "adminPages/executorEditPage";
    }

    @PostMapping("executors/{id}")
    public String performEditExecutor(@PathVariable("id") int id, @ModelAttribute("executor") Person person){
        adminService.adminLimit();

        registrationService.save(person);

        return "redirect:/executors";
    }

    @PostMapping("deleteExecutor/{id}")
    private String deleteExecutor(@PathVariable("id") int id){
        adminService.adminLimit();

        personDetailsService.deleteExecutor(id);

        return "redirect:/executors";
    }

}

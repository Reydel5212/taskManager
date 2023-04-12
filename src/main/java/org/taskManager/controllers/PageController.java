package org.taskManager.controllers;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.taskManager.models.Task;
import org.taskManager.services.AddTaskService;
import org.taskManager.services.AdminService;
import org.taskManager.services.GeneralService;
import org.taskManager.services.TaskService;

@Controller
public class PageController {
    private final AdminService adminService;
    private final GeneralService generalService;
    private final TaskService taskService;
    private final AddTaskService addTaskService;

    @Autowired
    public PageController(AdminService adminService, GeneralService generalService, TaskService taskService, AddTaskService addTaskService){
        this.adminService = adminService;
        this.generalService = generalService;
        this.taskService = taskService;
        this.addTaskService = addTaskService;
    }

    /*General Pages*/
    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("person", generalService.getPersonDetails());
        model.addAttribute("time", generalService.getCurrentDate());

        return "pages/main";
    }

    @GetMapping("/task")
    public String taskPage(Model model){
        model.addAttribute("person", generalService.getPersonDetails());
        model.addAttribute("time", generalService.getCurrentDate());
        model.addAttribute("tasks", taskService.findAll());

        return "pages/task";
    }

    @GetMapping("/stat")
    public String statisticPage(Model model){
        model.addAttribute("person", generalService.getPersonDetails());
        model.addAttribute("time", generalService.getCurrentDate());

        return "pages/stat";
    }

    @GetMapping("/settings")
    public String settingsPage(Model model){
        model.addAttribute("person", generalService.getPersonDetails());
        model.addAttribute("time", generalService.getCurrentDate());

        return "pages/settings";
    }

    @GetMapping("/info")
    public String infoPage(Model model){
        model.addAttribute("person", generalService.getPersonDetails());
        model.addAttribute("time", generalService.getCurrentDate());

        return "pages/info";
    }


    /*Admin Pages*/
    @GetMapping("/addTask")
    public String addTaskPage(@ModelAttribute("task") Task task, Model model){
        adminService.adminLimit();
        model.addAttribute("person", generalService.getPersonDetails());
        model.addAttribute("time", generalService.getCurrentDate());

        return "adminPages/addTask";
    }

    @PostMapping("/addTask")
    public String performTaskPage(@ModelAttribute("task") Task task){
        addTaskService.addTask(task);

        return "redirect:/task";
    }

    @GetMapping("task/{id}")
    public String showTask(@PathVariable("id") int id, Model model){
        model.addAttribute("person", generalService.getPersonDetails());
        model.addAttribute("time", generalService.getCurrentDate());
        model.addAttribute("task", taskService.findOne(id));

        return "pages/show";
    }

    @GetMapping("task/{id}/edit")
    public String editTask(@PathVariable("id") int id, Model model){
        model.addAttribute("task",taskService.findOne(id));

        return "adminPages/editPage";
    }

    @PostMapping("task/{id}")
    public String performEditTask(@PathVariable("id") int id, @ModelAttribute("task") Task task){

        taskService.save(task);
        return "redirect:/task";
    }

    @GetMapping("/admin")
    public String adminPage(){
        adminService.adminLimit();

        return "admin";
    }

    @PostMapping("/{id}")
    public String deleteTask(@PathVariable("id") int id){
        taskService.delete(id);
        return "redirect:/task";
    }
}

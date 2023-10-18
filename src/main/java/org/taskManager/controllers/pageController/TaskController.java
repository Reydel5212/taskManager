package org.taskManager.controllers.pageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.taskManager.models.object.Person;
import org.taskManager.models.object.Task;
import org.taskManager.models.object.TaskArchive;
import org.taskManager.services.*;

import javax.validation.Valid;

@Controller
public class TaskController {

    private final GeneralService generalService;
    private final AdminService adminService;
    private final TaskService taskService;
    private final PersonDetailsService personDetailsService;

    @Autowired
    public TaskController(GeneralService generalService, AdminService adminService,
                          TaskService taskService, PersonDetailsService personDetailsService) {
        this.generalService = generalService;
        this.adminService = adminService;
        this.taskService = taskService;
        this.personDetailsService = personDetailsService;
    }

    /* Standard Pages*/
    // For all
    // The task shown on the page

    @GetMapping("/task")
    public String taskPage(Model model){
        generalService.getGeneralModels(model);

        model.addAttribute("tasks", (generalService.getPersonRole().equals("ROLE_USER")) ?
                taskService.getTaskByIntervalStatusAndTaskExecutorId(1,0) : taskService.findAll());

        taskService.setTaskTimeStampInterval();

        return "pages/task";
    }

    // Task info

    @GetMapping("task/{id}")
    public String showTask(@PathVariable("id") int id, Model model){
        generalService.getGeneralModels(model);

        model.addAttribute("task", taskService.findOne(id));
        model.addAttribute("taskImage", taskService.findOne(id).getGeneralImage());
        model.addAttribute("currentPersonId", generalService.getPersonId());

        System.out.println(taskService.findOne(id).getGeneralImage().getImagePath());
        return "pages/show";
    }


    /* Modify Pages */
    // Only for admin
    // Add task

    @GetMapping("/addTask")
    public String addTaskPage(@ModelAttribute("task") Task task, Model model, @ModelAttribute("executor") Person person){
        adminService.adminLimit();
        generalService.getGeneralModels(model);

        model.addAttribute("executors", personDetailsService.findAll());

        return "adminPages/addTask";
    }

    @PostMapping("/addTask")
    public String performTaskPage(@ModelAttribute("task") @Valid Task task, BindingResult bindingResult, @RequestParam("file") MultipartFile file,
                                  @ModelAttribute("executor")Person person, Model model) {
        adminService.adminLimit();

        Person personProfileName = personDetailsService.findOne(person.getId());

        if(bindingResult.hasErrors()){
            generalService.getGeneralModels(model);

            return "adminPages/addTask";}

        taskService.addTask(file, task, personProfileName);

        return "redirect:/task";
    }

    // Edit task
    @GetMapping("task/{id}/edit")
    public String editTask(@PathVariable("id") int id, Model model){
        adminService.adminLimit();
        generalService.getGeneralModels(model);

        model.addAttribute("task",taskService.findOne(id));

        return "adminPages/editPage";
    }

    @PostMapping("task/{id}")
    public String performEditTask(@PathVariable("id") int id, @ModelAttribute("task") @Valid Task task, BindingResult bindingResult){
        adminService.adminLimit();

        if(bindingResult.hasErrors()){
            return "redirect:/task/{id}/edit";
        }

        taskService.save(task);

        return "redirect:/task";
    }

    // Changes the task performer

    @PostMapping("task/{id}/change")
    public String changeTaskExecutor(@PathVariable("id") int id, @ModelAttribute("task") Task task){

        Task currentTask = taskService.findOne(task.getId());
        String executorName = generalService.getPersonExecutorName();
        int executorId = generalService.getPersonId();

        taskService.changeExecutorName(currentTask, executorName, executorId);

        return "redirect:/task";
    }

    // Delete task

    @PostMapping("deleteTask/{id}")
    public String deleteTask(@PathVariable("id") int id){

        taskService.deleteTask(id);
        return "redirect:/task";
    }

    // Cancel task

    @PostMapping("task/{id}/cancel")
    public String cancelTask(@PathVariable("id") int id){
        Task task = taskService.findOne(id);

        taskService.cancelTask(task);

        return "redirect:/task";
    }

    // Report page

    @GetMapping("task/{id}/report")
    public String reportPage(@PathVariable("id") int id, Model model, @ModelAttribute("taskArchive") TaskArchive taskArchive){
        generalService.getGeneralModels(model);
        model.addAttribute("task", taskService.getTaskById(id));

        return "pages/report";
    }

    @PostMapping("task/{id}/report")
    public String performReportPage(@PathVariable("id") int id, TaskArchive taskArchive, @RequestParam("file") MultipartFile file) {
        Task task = taskService.findOne(id);

        taskService.addTaskArchive(task, taskArchive, file);

        taskService.changeIntervalStatus(task);

        taskService.setTaskUpdateTimStamp(task);

        return "redirect:/main";
    }

    // Task Archive page

    @GetMapping("taskArchive/{id}")
    private String taskArchive(@PathVariable("id") int id, Model model){
        model.addAttribute("taskArchive", taskService.findTaskArchiveById(id));
        model.addAttribute("reportImage", taskService.findTaskArchiveById(id).getReportImage());

        generalService.getGeneralModels(model);

        return "pages/taskArchive";
    }

}

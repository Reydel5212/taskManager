package org.taskManager.pageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;
import org.taskManager.models.Person;
import org.taskManager.services.AdminService;
import org.taskManager.services.GeneralService;
import org.taskManager.services.PersonDetailsService;
import org.taskManager.services.RegistrationService;
import org.taskManager.util.PersonValidator;

import java.io.IOException;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final PersonValidator personValidator;
    private final RegistrationService registrationService;
    private final GeneralService generalService;
    private final AdminService adminService;
    private final PersonDetailsService personDetailsService;

    @Autowired
    public AuthController(PersonValidator personValidator, RegistrationService registrationService, GeneralService generalService, AdminService adminService, PersonDetailsService personDetailsService){
        this.personValidator = personValidator;
        this.registrationService = registrationService;
        this.generalService = generalService;
        this.adminService = adminService;
        this.personDetailsService = personDetailsService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person, Model model){
        adminService.adminLimit();
        model.addAttribute("executorProfileName", generalService.getPersonDetails());
        model.addAttribute("time", generalService.getCurrentDate());
        model.addAttribute("profileImg", personDetailsService.findOne(generalService.getPersonId()).getProfileImages());

        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, Model model, @RequestParam("file1") MultipartFile file1)
    throws IOException {
        adminService.adminLimit();

        personValidator.validate(person, bindingResult);

        model.addAttribute("executorProfileName", generalService.getPersonDetails());
        model.addAttribute("time", generalService.getCurrentDate());
        model.addAttribute("profileImg", personDetailsService.findOne(generalService.getPersonId()).getProfileImages());

        if (file1.isEmpty()){
            return "/auth/registration";
        }

        if(bindingResult.hasErrors()){
            return "/auth/registration";}

        registrationService.register(person, file1);

        return "redirect:/executors";
    }

}

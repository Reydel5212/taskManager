package org.taskManager.controllers.pageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.taskManager.models.object.Description;
import org.taskManager.services.AdminService;
import org.taskManager.services.DescriptionService;
import org.taskManager.services.GeneralService;
import org.taskManager.services.PersonDetailsService;

@Controller
public class InfoController {
    private final GeneralService generalService;
    private final DescriptionService descriptionService;
    private final AdminService adminService;
    private final PersonDetailsService personDetailsService;

    @Autowired
    public InfoController(GeneralService generalService, DescriptionService descriptionService, AdminService adminService, PersonDetailsService personDetailsService) {
        this.generalService = generalService;
        this.descriptionService = descriptionService;
        this.adminService = adminService;
        this.personDetailsService = personDetailsService;
    }

    @GetMapping("/info")
    public String infoPage(Model model){
        generalService.getGeneralModels(model);
        model.addAttribute("descInfo", descriptionService.findDescription());

        return "pages/info";
    }

    /*Admin Pages*/
    @GetMapping("info/{id}/edit")
    public String editInfo(@PathVariable("id") int id, Model model){
        adminService.adminLimit();
        generalService.getGeneralModels(model);
        model.addAttribute("desc", descriptionService.findOneDescription(id));

        return "adminPages/editInfo";
    }
    @PostMapping("editInfo/{id}")
    public String performEditInfo(@PathVariable("id") int id, @ModelAttribute("desc") Description description){
        adminService.adminLimit();
        descriptionService.changeDescription(description);

        return "redirect:/info";
    }
}

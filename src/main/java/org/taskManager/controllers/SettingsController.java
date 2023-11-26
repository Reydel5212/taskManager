package org.taskManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.taskManager.services.GeneralService;
import org.taskManager.services.PersonDetailsService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SettingsController {
    private final GeneralService generalService;
    private final PersonDetailsService personDetailsService;

    @Autowired
    public SettingsController(GeneralService generalService, PersonDetailsService personDetailsService) {
        this.generalService = generalService;
        this.personDetailsService = personDetailsService;
    }

    @GetMapping("/settings")
    public String settingsPage(Model model){
        generalService.getGeneralModels(model);

        return "pages/settings";
    }

    /*for Admin*/
    @PostMapping("/darkCookie")
    public String cookiePage(HttpServletResponse response){
        Cookie cookie = new Cookie("color", "dark");

        response.addCookie(cookie);

        return "redirect:/settings";
    }

    @PostMapping("/lightCookie")
    public String lightCookiePage(HttpServletResponse response){
        Cookie cookie = new Cookie("color","light");

        response.addCookie(cookie);


        return "redirect:/settings";
    }

    @PostMapping("/greyCookie")
    public String greyCookiePage(HttpServletResponse response){
        Cookie cookie = new Cookie("color","grey");

        response.addCookie(cookie);

        return "redirect:/settings";
    }

}

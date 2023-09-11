package org.taskManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import org.springframework.ui.Model;
import org.taskManager.security.PersonDetails;

@Service
public class GeneralService {

    private final DateService dateService;
    private final PersonDetailsService personDetailsService;

    private String time;

    @Autowired
    public GeneralService(DateService dateService, PersonDetailsService personDetailsService) {
        this.dateService = dateService;
        this.personDetailsService = personDetailsService;
    }

    public String getPersonDetails(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        return personDetails.getUsername();
    }

    public String getCurrentDate(){
        time = dateService.getDay() + ", " + dateService.getDate() + " " + dateService.getMonth();
        return time;
    }

    public String getPersonRole(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        return personDetails.getPerson().getRole();
    }

    public int getPersonId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        return personDetails.getPerson().getId();
    }

    public String getPersonExecutorName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        return personDetails.getPerson().getPerson_profile();
    }

    /* general models */
    public void getGeneralModels(Model model){
        model.addAttribute("person", getPersonDetails());
        model.addAttribute("time", getCurrentDate());
        model.addAttribute("profileImg", personDetailsService.findOne(getPersonId()).getProfileImages());
    }
}

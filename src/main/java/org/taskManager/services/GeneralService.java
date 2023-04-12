package org.taskManager.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.taskManager.security.PersonDetails;

@Service
public class GeneralService {
    private final DateService dateService;
    private String time;

    @Autowired
    public GeneralService(DateService dateService) {
        this.dateService = dateService;
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
}

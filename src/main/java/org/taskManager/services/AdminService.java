package org.taskManager.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void adminLimit(){

    }
    @PreAuthorize("hasRole('ROLE_USER')")
    public void userLimit(){

    }

}

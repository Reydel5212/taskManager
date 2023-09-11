package org.taskManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;
import org.taskManager.models.object.Person;
import org.taskManager.models.image.ProfileImage;
import org.taskManager.repositories.objectRepository.PeopleRepository;


import java.io.IOException;

@Service
public class RegistrationService {

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder){
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person person,  MultipartFile file1) throws IOException{
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");

        ProfileImage image1;

        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            person.addImageToProduct(image1);
        }

        peopleRepository.save(person);
    }

    private ProfileImage toImageEntity(MultipartFile file) throws IOException {
        ProfileImage image = new ProfileImage();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());

        return image;
    }

    @Transactional
    public void save(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        peopleRepository.save(person);
    }

}

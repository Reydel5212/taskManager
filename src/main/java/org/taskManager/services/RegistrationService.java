package org.taskManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;
import org.taskManager.models.image.ProfileImageModel;
import org.taskManager.models.object.Person;
import org.taskManager.repositories.objectRepository.PersonRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class RegistrationService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final ImageConverterService imageConverterService;
    private static final String PROFILE_IMAGE_DIRECTORY = "src/main/resources/static/ProfileImages/";

    @Autowired
    public RegistrationService(PersonRepository personRepository, PasswordEncoder passwordEncoder, ImageConverterService imageConverterService){
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
        this.imageConverterService = imageConverterService;
    }

    @Transactional
    public void personRegistration(Person person,  MultipartFile image) {
        ProfileImageModel profileImage;
        Path imagePath = Paths.get(PROFILE_IMAGE_DIRECTORY + image.getOriginalFilename());

        try {
            byte[] imageBytes = image.getBytes();

            if (image.getSize() != 0) {

                if(Files.exists(imagePath)){

                    Files.write(imagePath, imageBytes);
                }else {
                    Files.write(imagePath, imageBytes);
                }

                profileImage = imageConverterService.toProfileImage(image);
                person.addImageToPerson(profileImage);
            }
        } catch (Exception e){};

        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");

        personRepository.save(person);
    }

    @Transactional
    public void save(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personRepository.save(person);
    }

}

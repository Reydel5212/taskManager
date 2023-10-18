package org.taskManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.taskManager.models.object.Person;
import org.taskManager.repositories.objectRepository.PersonRepository;
import org.taskManager.security.PersonDetails;

@Service
public class PersonDetailsService implements UserDetailsService {

    public static final String PROFILE_IMAGE_DIRECTORY = "src/main/resources/static/ProfileImages/";
    private final PersonRepository personRepository;

    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByUsername(s);

        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new PersonDetails(person.get());
    }

    @Transactional(readOnly = true)
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Person findOne(int id){
        Optional<Person> foundPerson = personRepository.findById(id);

        return foundPerson.orElse(null);
    }

    @Transactional
    public void deleteExecutor(int id){
        Person person = personRepository.getById(id);
        String profileImage = person.getProfileImageModel().getImageName();
        Path imagePath = Paths.get(PROFILE_IMAGE_DIRECTORY + profileImage);

        try{
            if (Files.exists(imagePath)){
                Files.delete(imagePath);
            } else {
                System.out.println("File do not exist");
            }
        }catch (Exception e){}

        personRepository.deleteById(id);
    }

    public List<Person> findAllExecutorsWithoutZero(){
        return personRepository.findAllExecutorsWithoutZero();
    }

}

package org.taskManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.taskManager.models.object.Description;
import org.taskManager.repositories.objectRepository.DescriptionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DescriptionService {

    private final DescriptionRepository descriptionRepository;

    @Autowired
    public DescriptionService(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }

    public List<Description> findDescription(){
        return descriptionRepository.findAll();
    }

    public Description findOneDescription(int id){
         Optional<Description> foundDesc = descriptionRepository.findById(id);
         return foundDesc.orElse(null);
    }

    @Transactional
    public void save(Description description){
        descriptionRepository.save(description);
    }

}

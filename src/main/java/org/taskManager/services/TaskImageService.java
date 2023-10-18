package org.taskManager.services;

import org.springframework.stereotype.Service;
import org.taskManager.repositories.imageRepository.TaskImageRepository;

@Service
public class TaskImageService {

    private final TaskImageRepository taskImageRepository;


    public TaskImageService(TaskImageRepository taskImageRepository) {
        this.taskImageRepository = taskImageRepository;
    }

    

}

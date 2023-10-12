package org.taskManager.services;

import org.springframework.stereotype.Service;
import org.taskManager.models.image.GeneralImage;
import org.taskManager.repositories.imageRepository.GeneralImageRepository;

@Service
public class TaskImageService {

    private final GeneralImage generalImage;
    private final GeneralImageRepository generalImageRepository;

    public TaskImageService(GeneralImage generalImage, GeneralImageRepository generalImageRepository) {
        this.generalImage = generalImage;
        this.generalImageRepository = generalImageRepository;
    }

}

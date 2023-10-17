package org.taskManager.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.taskManager.models.image.GeneralImage;
import org.taskManager.models.object.Task;
import org.taskManager.repositories.imageRepository.GeneralImageRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskImageService {

    private final GeneralImageRepository generalImageRepository;


    public TaskImageService(GeneralImageRepository generalImageRepository) {
        this.generalImageRepository = generalImageRepository;
    }

    

}

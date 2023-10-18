package org.taskManager.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.taskManager.models.image.GeneralImage;

@Service
public class ToImageService {
    public GeneralImage toGeneralImage(MultipartFile file){
        GeneralImage image = new GeneralImage();
        image.setImageName(file.getOriginalFilename());
        image.setImageSize(1);
        image.setImagePath("/TaskImages/" + file.getOriginalFilename());

        return image;
    }
}

package org.taskManager.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.taskManager.models.image.ProfileImageModel;
import org.taskManager.models.image.ReportImageModel;
import org.taskManager.models.image.TaskImageModel;

@Service
public class ImageConverterService {
    public TaskImageModel toTaskImage(MultipartFile file){
        TaskImageModel image = new TaskImageModel();

        image.setImageName(file.getOriginalFilename());
        image.setImageSize(1);
        image.setImagePath("/TaskImages/" + file.getOriginalFilename());

        return image;
    }

    public ProfileImageModel toProfileImage(MultipartFile file){
        ProfileImageModel image = new ProfileImageModel();

        image.setImageName(file.getOriginalFilename());
        image.setImageSize(1);
        image.setImagePath("/ProfileImages/" + file.getOriginalFilename());

        return image;
    }

    public ReportImageModel toReportImage(MultipartFile image){
        ReportImageModel reportImage = new ReportImageModel();

        reportImage.setImageName(image.getOriginalFilename());
        reportImage.setImageSize(1);
        reportImage.setImagePath("/ReportImages/" + image.getOriginalFilename());

        return reportImage;
    }

}

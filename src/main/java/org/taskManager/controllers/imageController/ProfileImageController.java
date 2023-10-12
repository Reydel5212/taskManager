package org.taskManager.controllers.imageController;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.taskManager.models.image.ProfileImage;
import org.taskManager.repositories.imageRepository.ProfileImageRepository;

import java.io.ByteArrayInputStream;

@Controller
public class ProfileImageController {

    private final ProfileImageRepository profileImageRepository;

    public ProfileImageController(ProfileImageRepository profileImageRepository) {
        this.profileImageRepository = profileImageRepository;
    }

    @GetMapping("/profileImages/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id) {
        ProfileImage image = profileImageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }

}

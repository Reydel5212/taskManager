package org.taskManager.controllers.imageController;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.taskManager.models.image.ReportImage;
import org.taskManager.repositories.imageRepository.TaskArchiveImageRepository;

import java.io.ByteArrayInputStream;

@Controller
public class TaskArchiveImageController {
    private final TaskArchiveImageRepository taskArchiveImageRepository;

    public TaskArchiveImageController(TaskArchiveImageRepository taskArchiveImageRepository) {
        this.taskArchiveImageRepository = taskArchiveImageRepository;
    }

    @GetMapping("/taskArchiveImage/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id) {
        ReportImage image = taskArchiveImageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}

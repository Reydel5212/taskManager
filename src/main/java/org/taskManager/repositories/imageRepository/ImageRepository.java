package org.taskManager.repositories.imageRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskManager.models.image.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}

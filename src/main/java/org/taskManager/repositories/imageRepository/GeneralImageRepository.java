package org.taskManager.repositories.imageRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskManager.models.image.GeneralImage;

@Repository
public interface GeneralImageRepository extends JpaRepository<GeneralImage, Integer> {
}

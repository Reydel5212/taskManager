package org.taskManager.repositories.imageRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskManager.models.image.ReportImageModel;

@Repository
public interface TaskArchiveImageRepository extends JpaRepository<ReportImageModel, Integer> {
}

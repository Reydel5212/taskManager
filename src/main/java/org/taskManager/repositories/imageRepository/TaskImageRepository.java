package org.taskManager.repositories.imageRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskManager.models.image.TaskImageModel;

@Repository
public interface TaskImageRepository extends JpaRepository<TaskImageModel, Integer> {
}

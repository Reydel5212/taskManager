package org.taskManager.repositories.objectRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskManager.models.object.TaskArchive;

import java.util.List;

@Repository
public interface TaskArchiveRepository extends JpaRepository <TaskArchive, Integer> {
    int countByTaskExecutorId(int id);
    List<TaskArchive> findAllByTaskExecutorId(int id);

}

package org.taskManager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskManager.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}

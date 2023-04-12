package org.taskManager.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.taskManager.models.Task;
import org.taskManager.repositories.TaskRepository;

@Service
public class AddTaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public AddTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public void addTask(Task task){
        taskRepository.save(task);
    }
}

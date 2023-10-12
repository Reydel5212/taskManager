package org.taskManager.repositories.objectRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import org.taskManager.models.object.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findAllByTaskExecutorId(int id);

    @Modifying
    @Transactional
    @Query(value = "update task set task_interval_status = 1 where task_date <= current_timestamp", nativeQuery = true)
    int setTaskTimeStampInterval();

    @Query(value = "select * from task where task_interval_status = 1", nativeQuery = true)
    List<Task> getTaskByTaskIntervalStatus();

    @Modifying
    @Transactional
    @Query(value = "update task set task_date = current_timestamp + interval ? minute where task_id = ?", nativeQuery = true)
    int setTaskUpdateTimStamp(int taskInterval, int id);

    @Query(value = "select * from task where task_interval_status = ? and task_executor_id = ?", nativeQuery = true)
    List<Task> getTaskByIntervalStatusAndTaskExecutorId(int interval, int id);

}

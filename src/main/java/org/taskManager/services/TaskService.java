package org.taskManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;
import org.taskManager.models.image.Image;
import org.taskManager.models.image.ReportImage;
import org.taskManager.models.object.Person;
import org.taskManager.models.object.Task;
import org.taskManager.models.object.TaskArchive;
import org.taskManager.repositories.objectRepository.TaskArchiveRepository;
import org.taskManager.repositories.objectRepository.TaskRepository;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskArchiveRepository taskArchiveRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskArchiveRepository taskArchiveRepository) {
        this.taskRepository = taskRepository;
        this.taskArchiveRepository = taskArchiveRepository;
    }

    public List<Task> findAllByTaskExecutorId(int id){
        return taskRepository.findAllByTaskExecutorId(id);
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task findOne(int id){
        Optional<Task> foundTask = taskRepository.findById(id);

        return foundTask.orElse(null);
    }

    @Transactional
    public void save(Task task){
        taskRepository.save(task);
    }


    @Transactional
    public void delete(int id){
        taskRepository.deleteById(id);
    }

    public Task getTaskById(int id){
        return taskRepository.findById(id).orElse(null);
    }

    @Transactional
    public void changeExecutorName(Task task, String executorName, int executorId){
        task.setTask_executor_name(executorName);
        task.setTask_executor_id(executorId);
        taskRepository.save(task);
    }

    @Transactional
    public void cancelTask(Task task){
        task.setTask_executor_id(0);
        task.setTask_executor_name("Нет исполнителя");
        taskRepository.save(task);
    }

    public TaskArchive findTaskArchiveById(int id){
        Optional<TaskArchive> foundTaskArchive = taskArchiveRepository.findById(id);
        return foundTaskArchive.orElse(null);
    }


    @Transactional
    public void changeReportStatus(TaskArchive taskArchive, int statusNum){
        taskArchive.setReportStatus(statusNum);
        taskArchiveRepository.save(taskArchive);
    }

    @Transactional
    public void setTaskTimeStampInterval(){
        for (Task task : taskRepository.findAll()){
            taskRepository.findById(task.getId());
            taskRepository.setTaskTimeStampInterval();
        }
    }

    @Transactional
    public void changeIntervalStatus(Task task){
        task.setTask_interval_status(0);
        task.setTask_executor_id(0);
        taskRepository.save(task);
    }

    public List<Task> getTaskByTaskIntervalStatus(){
        return taskRepository.getTaskByTaskIntervalStatus();
    }

    @Transactional
    public void setTaskUpdateTimStamp(Task task){
        taskRepository.setTaskUpdateTimStamp(task.getTask_interval(), task.getId());
    }

    public List<Task> getTaskByIntervalStatusAndTaskExecutorId(int interval, int id){
        return taskRepository.getTaskByIntervalStatusAndTaskExecutorId(interval, id);
    }

    // Add task
    @Transactional
    public void addTask(Task task, MultipartFile file1, MultipartFile file2, MultipartFile file3, Person person, Person personProfileName) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            task.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            task.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            task.addImageToProduct(image3);
        }
        /*for fast create*/
        Task task1;
        task1 = toTaskEntity(person);
        task.setTask_executor_id(task1.getTask_executor_id());
        task.setTask_executor_name(personProfileName.getPerson_profile());
        task.setTask_interval_status(1);

        taskRepository.save(task);
    }

    private Task toTaskEntity(Person person){
        Task task = new Task();
        task.setTask_executor_name(person.getPerson_profile());
        task.setTask_executor_id(person.getId());

        return task;
    }

    @Transactional
    public void addTaskArchive(Task task, TaskArchive taskArchive, MultipartFile file) throws IOException {
        ReportImage image;

        if (file.getSize() != 0) {
            image = toReportImageEntity(file);
            taskArchive.addImageToProduct(image);
        }

        taskArchive.setTask_name(task.getTask_name());
        taskArchive.setTask_desc(task.getTask_desc());
        taskArchive.setTask_date(task.getTask_date());
        taskArchive.setTaskExecutorId(task.getTask_executor_id());
        taskArchive.setTask_executor_name(task.getTask_executor_name());
        taskArchive.setTask_time(Timestamp.valueOf(LocalDateTime.now()));
        taskArchive.setReportStatus(0);

        taskArchiveRepository.save(taskArchive);
    }

    private ReportImage toReportImageEntity(MultipartFile file) throws IOException {
        ReportImage image = new ReportImage();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

}

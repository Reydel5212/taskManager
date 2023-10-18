package org.taskManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.taskManager.models.image.ReportImageModel;
import org.taskManager.models.image.TaskImageModel;
import org.taskManager.models.object.Person;
import org.taskManager.models.object.Task;
import org.taskManager.models.object.TaskArchive;
import org.taskManager.repositories.imageRepository.TaskImageRepository;
import org.taskManager.repositories.objectRepository.TaskArchiveRepository;
import org.taskManager.repositories.objectRepository.TaskRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TaskService {

    private static final String TASK_IMAGE_DIRECTORY = "src/main/resources/static/TaskImages/";
    private static final String REPORT_IMAGE_DIRECTORY = "src/main/resources/static/ReportImages/";
    private final TaskRepository taskRepository;
    private final TaskArchiveRepository taskArchiveRepository;
    private final TaskImageRepository taskImageRepository;
    private final ImageConverterService imageConverterService;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskArchiveRepository taskArchiveRepository, TaskImageRepository taskImageRepository, ImageConverterService imageConverterService) {
        this.taskRepository = taskRepository;
        this.taskArchiveRepository = taskArchiveRepository;
        this.taskImageRepository = taskImageRepository;
        this.imageConverterService = imageConverterService;
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
    public void deleteTask(int id){
        Task task = taskRepository.getById(id);
        String taskImagePath = task.getGeneralImage().getImageName();

        Path imagePath = Paths.get(TASK_IMAGE_DIRECTORY + taskImagePath);

        try{
            Files.delete(imagePath);
        }catch (Exception e){}

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

    @Transactional
    public void setTaskUpdateTimStamp(Task task){
        taskRepository.setTaskUpdateTimStamp(task.getTask_interval(), task.getId());
    }

    public List<Task> getTaskByIntervalStatusAndTaskExecutorId(int interval, int id){
        return taskRepository.getTaskByIntervalStatusAndTaskExecutorId(interval, id);
    }

    // Add task
    @Transactional
    public void addTask(@RequestParam("file") MultipartFile image, Task task, Person personProfileName) {
        TaskImageModel taskImage;

        Path imagePath = Paths.get(TASK_IMAGE_DIRECTORY + image.getOriginalFilename());


        if(image.getSize() != 0){

            try{
                byte[] imageBytes = image.getBytes();

                if(Files.exists(imagePath)){
                    System.out.println("File already exist");
                }else {
                    Files.write(imagePath, imageBytes);
                }

            } catch (IOException e){};

            taskImage = imageConverterService.toTaskImage(image);
            task.addImageToTask(taskImage);
        }

        task.setTask_executor_name(personProfileName.getPerson_profile());

        taskRepository.save(task);
    }

    @Transactional
    public void addTaskArchive(Task task, TaskArchive taskArchive, MultipartFile image) {
        ReportImageModel reportImage;

        Path imagePath = Paths.get(REPORT_IMAGE_DIRECTORY + image.getOriginalFilename());

        if(image.getSize() != 0){

            try{
                byte[] imageBytes = image.getBytes();

                if(Files.exists(imagePath)){
                    System.out.println("File already exist");
                }else {
                    Files.write(imagePath, imageBytes);
                }

            } catch (IOException e){};

            reportImage = imageConverterService.toReportImage(image);
            taskArchive.addTaskToTaskArchive(reportImage);
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
}

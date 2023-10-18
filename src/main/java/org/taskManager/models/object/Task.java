package org.taskManager.models.object;

import org.taskManager.models.image.TaskImageModel;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int id;

    @NotEmpty(message = "Это поле не может быть пустым")
    @Column(name = "task_name")
    private String task_name;

    @NotEmpty(message = "Это поле не может быть пустым")
    @Size(min = 1, max = 150, message = "Минимальное количество символов 0, максимальное 150")
    @Column(name = "task_desc")
    private String task_desc;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "task_date")
    private Date task_date;

    @Column(name = "task_executor_name")
    private String task_executor_name;

    @Column(name = "task_executor_id")
    private int taskExecutorId;

    @Column(name = "task_interval")
    private int task_interval;

    @Column(name = "task_interval_status")
    private int task_interval_status;



    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "task")
    private TaskImageModel taskImageModel;



    public void addImageToTask(TaskImageModel image){
        image.setTask(this);
        this.taskImageModel = image;
    }


    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setTask_name(String task_name){
        this.task_name = task_name;
    }
    public String getTask_name(){
        return task_name;
    }

    public void setTask_desc(String task_desc){
        this.task_desc = task_desc;
    }
    public String getTask_desc(){return task_desc;}

    public void setTask_date(Date task_date){
        this.task_date = task_date;
    }
    public Date getTask_date(){
        return task_date;
    }

    public void setTask_executor_id(int task_executor_id){
        this.taskExecutorId = task_executor_id;
    }
    public int getTask_executor_id(){
        return taskExecutorId;
    }

    public void setTask_executor_name(String task_executor_name){ this.task_executor_name = task_executor_name;}
    public String getTask_executor_name(){ return task_executor_name;}

    public int getTask_interval() {
        return task_interval;
    }
    public void setTask_interval(int task_interval) {
        this.task_interval = task_interval;
    }

    public int getTask_interval_status() {
        return task_interval_status;
    }
    public void setTask_interval_status(int task_interval_status) {
        this.task_interval_status = task_interval_status;
    }

    @Override
    public String toString(){
        return  "Task { " +
                " taskId = "+ id +
                " taskName = "+ task_name +
                " taskDate = "+ task_date +
                " taskExecutorName = "+ task_executor_name +
                " taskExecutorId = "+ taskExecutorId +
                " }";
    }

    public TaskImageModel getGeneralImage() {
        return taskImageModel;
    }

    public void setGeneralImage(TaskImageModel taskImageModel) {
        this.taskImageModel = taskImageModel;
    }
}

package org.taskManager.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "task_date")
    private Date task_date;

    @Column(name = "task_executor_name")
    private String task_executor_name;

    @Column(name = "task_executor_id")
    private int taskExecutorId;
    
    @Column(name = "task_status")
    private int task_status;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "task")
    private List<Image> images = new ArrayList<>();

    /*@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Person person;*/

    public void addImageToProduct(Image image) {
        image.setTask(this);
        images.add(image);
    }


    public void setImages(List<Image> images){
        this.images = images;
    }
    public List<Image> getImages(){
        return images;
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

    public void setTask_status(int task_status){
        this.task_status = task_status;
    }
    public int getTask_status(){
        return task_status;
    }

    @Override
    public String toString(){
        return  "Task { " +
                " taskId = "+ id +
                " taskName = "+ task_name +
                " taskDate = "+ task_date +
                " taskExecutorName = "+ task_executor_name +
                " taskExecutorId = "+ taskExecutorId +
                " taskStatus = "+ task_status +
                " }";
    }




    public void setPreviewImageId(){

    }


}

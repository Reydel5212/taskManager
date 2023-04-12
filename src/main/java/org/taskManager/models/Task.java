package org.taskManager.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int id;

    @Column(name = "task_name")
    private String task_name;

    @Column(name = "task_desc")
    private String task_desc;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "task_date")
    private Date task_date;

    @Column(name = "task_executor_name")
    private String task_executor_name;

    @Column(name = "task_executor_id")
    private int task_executor_id;

    @Column(name = "task_status")
    private int task_status;

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
        this.task_executor_id = task_executor_id;
    }
    public int getTask_executor_id(){
        return task_executor_id;
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
        return "{"+"Task: "
                +"id - "+id
                +" taskName - "+task_name
                +" taskDate - "+task_date
                +" taskExecutorName - "+task_executor_name
                +" taskExecutorId - "+task_executor_id
                +" taskStatus - "+task_status
                +"}";
    }
}

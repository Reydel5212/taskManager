package org.taskManager.models.object;

import org.springframework.format.annotation.DateTimeFormat;
import org.taskManager.models.image.ReportImageModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task_archive")
public class TaskArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int id;

    @Column(name = "task_name")
    private String task_name;

    @Column(name = "task_desc")
    private String task_desc;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "task_date")
    private Date task_date;

    @Column(name = "task_executor_name")
    private String task_executor_name;

    @Column(name = "task_executor_id")
    private int taskExecutorId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "task_time")
    private Date task_time;


    @Column(name = "report_desc")
    private String report_desc;

    @Column(name = "report_status")
    private int reportStatus;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "taskArchive")
    private ReportImageModel reportImage;

    public void addTaskToTaskArchive(ReportImageModel image) {
        image.setTaskArchive(this);
        this.reportImage = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_desc() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc;
    }

    public Date getTask_date() {
        return task_date;
    }

    public void setTask_date(Date task_date) {
        this.task_date = task_date;
    }

    public String getTask_executor_name() {
        return task_executor_name;
    }

    public void setTask_executor_name(String task_executor_name) {
        this.task_executor_name = task_executor_name;
    }

    public int getTaskExecutorId() {
        return taskExecutorId;
    }

    public void setTaskExecutorId(int taskExecutorId) {
        this.taskExecutorId = taskExecutorId;
    }

    public Date getTask_time() {
        return task_time;
    }

    public void setTask_time(Date task_time) {
        this.task_time = task_time;
    }

    public String getReport_desc() {
        return report_desc;
    }

    public void setReport_desc(String report_desc) {
        this.report_desc = report_desc;
    }

    public int getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(int reportStatus) {
        this.reportStatus = reportStatus;
    }

    public ReportImageModel getReportImage() {
        return reportImage;
    }

    public void setReportImage(ReportImageModel reportImage) {
        this.reportImage = reportImage;
    }

    @Override
    public String toString() {
        return "TaskArchive{" +
                "id=" + id +
                ", task_name='" + task_name + '\'' +
                ", task_desc='" + task_desc + '\'' +
                ", task_date=" + task_date +
                ", task_executor_name='" + task_executor_name + '\'' +
                ", taskExecutorId=" + taskExecutorId +
                ", task_time=" + task_time +
                ", report_desc='" + report_desc + '\'' +
                ", reportStatus=" + reportStatus +
                ", reportImage=" + reportImage +
                '}';
    }
}

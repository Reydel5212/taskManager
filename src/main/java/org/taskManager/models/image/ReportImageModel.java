package org.taskManager.models.image;

import org.taskManager.models.object.TaskArchive;

import javax.persistence.*;

@Entity
@Table(name = "report_image")
public class ReportImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Integer imageId;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_size")
    private Integer imageSize;

    @Column(name = "image_path")
    private String imagePath;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private TaskArchive taskArchive;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getImageSize() {
        return imageSize;
    }

    public void setImageSize(Integer imageSize) {
        this.imageSize = imageSize;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public TaskArchive getTaskArchive() {
        return taskArchive;
    }

    public void setTaskArchive(TaskArchive taskArchive) {
        this.taskArchive = taskArchive;
    }

    @Override
    public String toString() {
        return "ReportImageModel{" +
                "imageId=" + imageId +
                ", imageName='" + imageName + '\'' +
                ", imageSize=" + imageSize +
                ", imagePath='" + imagePath + '\'' +
                ", taskArchive=" + taskArchive +
                '}';
    }
}

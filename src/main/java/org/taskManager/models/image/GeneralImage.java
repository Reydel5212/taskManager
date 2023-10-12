package org.taskManager.models.image;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class GeneralImage {

    @Id
    @Column(name = "image_id")
    Integer imageId;

    @Column(name = "image_task_id")
    Integer imageTaskId;

    @Column(name = "image_name")
    String imageName;

    @Column(name = "image_size")
    Integer imageSize;

    @Column(name = "image_path")
    String imagePath;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getImageTaskId() {
        return imageTaskId;
    }

    public void setImageTaskId(Integer imageTaskId) {
        this.imageTaskId = imageTaskId;
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

    @Override
    public String toString() {
        return "GeneralImage{" +
                "imageId=" + imageId +
                ", imageTaskId=" + imageTaskId +
                ", imageName='" + imageName + '\'' +
                ", imageSize=" + imageSize +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}

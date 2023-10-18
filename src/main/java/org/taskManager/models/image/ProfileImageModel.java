package org.taskManager.models.image;

import org.taskManager.models.object.Person;

import javax.persistence.*;

@Entity
@Table(name = "profile_image")
public class ProfileImageModel {

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
    private Person person;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "ProfileImageModel{" +
                "imageId=" + imageId +
                ", imageName='" + imageName + '\'' +
                ", imageSize=" + imageSize +
                ", imagePath='" + imagePath + '\'' +
                ", person=" + person +
                '}';
    }
}

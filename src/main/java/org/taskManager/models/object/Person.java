package org.taskManager.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Логин не должен быть пустым")
    @Size(min = 1, max = 100, message = "Имя должно быть от 2 до 100 символов длиной")
    @Column(name = "person_username")
    private String username;

    @NotEmpty(message = "Пароль не должен быть пустым")
    @Column(name = "person_password")
    private String password;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Column(name = "person_profile")
    private String person_profile;

    @Column(name = "person_role")
    private String role;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private List<ProfileImage> profileImages = new ArrayList<>();

    /*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private List<Task> tasks = new ArrayList<>();*/

    public void addImageToProduct(ProfileImage image) {
        image.setPerson(this);
        profileImages.add(image);
    }

    public Person() {
    }

    public Person(String username, String person_profile) {
        this.username = username;
        this.person_profile = person_profile;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setPerson_profile(String person_profile){ this.person_profile = person_profile; }
    public String getPerson_profile(){ return person_profile; }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setRole(String role){ this.role = role; }
    public String getRole(){ return role; }

    @Override
    public String toString() {
        return "Person { " +
                " id = " + id +
                " username = " + person_profile +
                " password = " + username +
                " profileName = " + password +
                " role = " + role +
                " }";
    }

    public List<ProfileImage> getProfileImages() {
        return profileImages;
    }

    public void setProfileImages(List<ProfileImage> profileImages) {
        this.profileImages = profileImages;
    }
}
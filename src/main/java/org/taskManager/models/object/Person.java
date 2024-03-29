package org.taskManager.models.object;

import org.taskManager.models.image.ProfileImageModel;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private ProfileImageModel profileImageModel;

    public void addImageToPerson(ProfileImageModel image){
        image.setPerson(this);
        this.profileImageModel = image;
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

    public ProfileImageModel getProfileImageModel() {
        return profileImageModel;
    }

    public void setProfileImageModel(ProfileImageModel profileImageModel) {
        this.profileImageModel = profileImageModel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", person_profile='" + person_profile + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
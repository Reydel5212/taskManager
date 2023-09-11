package org.taskManager.models.object;

import javax.persistence.*;

@Entity
@Table(name = "description")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "description_id")
    private int id;
    @Column(name = "first_paragraph")
    private String first_para;
    @Column(name = "second_paragraph")
    private String second_para;

    public Description() { }

    public Description(String first_para, String second_para){
        this.first_para = first_para;
        this.second_para = second_para;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setFirst_para(String first_para){
        this.first_para = first_para;
    }
    public String getFirst_para(){
        return first_para;
    }

    public void setSecond_para(String second_para){
        this.second_para = second_para;
    }
    public String getSecond_para(){
        return second_para;
    }

    @Override
    public String toString(){
        return "Description{ " +
                " id = " + id +
                " first_para = " + first_para +
                " second_para = " + second_para;
    }
}

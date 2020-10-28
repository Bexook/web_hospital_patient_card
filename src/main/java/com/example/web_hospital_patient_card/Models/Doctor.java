package com.example.web_hospital_patient_card.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor_data_table")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(targetEntity = User.class,cascade = CascadeType.ALL)
    private List<User> userList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

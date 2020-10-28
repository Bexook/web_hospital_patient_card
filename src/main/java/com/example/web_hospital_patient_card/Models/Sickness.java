package com.example.web_hospital_patient_card.Models;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.List;

@Entity
@Table(name = "sickness_data_table")
public class Sickness {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name",nullable = false,unique = true)
    private String name;


    @ManyToMany(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinTable(name = "user_sickness_reference",
            joinColumns = {@JoinColumn(name = "sickness_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")})
    private List<User> userList;

    public Sickness() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

package com.example.web_hospital_patient_card.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pills_data_table")
public class Pill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "pill_name", nullable = false,unique = true)
    private String name;


    @ManyToMany(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinTable(name = "pill_user_reference",
            joinColumns = {@JoinColumn(name = "pill_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")})
    private List<User> userList;


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

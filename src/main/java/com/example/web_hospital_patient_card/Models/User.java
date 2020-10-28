package com.example.web_hospital_patient_card.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "user_data_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "surname",nullable = false)
    private String surname;


    @Column(name = "birth_date",nullable = false)
    private Date birthDate;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "e_mail",nullable = false,unique = true)
    private String email;

    @Column(name = "last_attendance_date")
    private Date lastAttendanceDate;

    @Column(name = "recovery_period")
    private int recoveryPeriod;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @JoinColumn(name = "family_doctor")
    @ManyToOne(targetEntity = Doctor.class,cascade = CascadeType.ALL)
    private Doctor doctor;


    @ManyToMany(targetEntity = Sickness.class,cascade = CascadeType.ALL)
    @JoinTable(name = "user_sickness_reference",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "sickness_id",referencedColumnName = "id")})
    private List<Sickness> sicknessList;


    @ManyToMany(targetEntity = Pill.class,cascade = CascadeType.ALL)
    @JoinTable(name = "pill_user_reference",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "pill_id",referencedColumnName = "id")})
    private List<Pill> pillList;


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastAttendanceDate() {
        return lastAttendanceDate;
    }

    public void setLastAttendanceDate(Date lastAttendanceDate) {
        this.lastAttendanceDate = lastAttendanceDate;
    }

    public int getRecoveryPeriod() {
        return recoveryPeriod;
    }

    public void setRecoveryPeriod(int recoveryPeriod) {
        this.recoveryPeriod = recoveryPeriod;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Sickness> getSicknessList() {
        return sicknessList;
    }

    public void setSicknessList(List<Sickness> sicknessList) {
        this.sicknessList = sicknessList;
    }

    public List<Pill> getPillList() {
        return pillList;
    }

    public void setPillList(List<Pill> pillList) {
        this.pillList = pillList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", lastAttendanceDate=" + lastAttendanceDate +
                ", recoveryPeriod=" + recoveryPeriod +
                ", role=" + role +
                ", doctor=" + doctor +
                ", sicknessList=" + sicknessList +
                ", pillList=" + pillList +
                '}';
    }
}

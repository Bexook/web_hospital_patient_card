package com.example.web_hospital_patient_card.Models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Lombok;
import org.apache.catalina.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "recovery_period")
public class RecoveryPeriod {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "begin")
    private LocalDate begin;

    @Column(name = "end")
    private LocalDate end;

    @ManyToOne(targetEntity = UserEntity.class,fetch = FetchType.LAZY)
    private UserEntity userEntity;
}

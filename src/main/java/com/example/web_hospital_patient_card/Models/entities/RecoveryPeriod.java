package com.example.web_hospital_patient_card.Models.entities;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
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

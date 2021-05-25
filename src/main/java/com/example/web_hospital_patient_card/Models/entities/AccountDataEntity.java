package com.example.web_hospital_patient_card.Models.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "account_data")
public class AccountDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "is-active")
    private boolean isActive;

    @Column(name = "is_password_expired")
    private boolean isPasswordExpired;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "last_update_date")
    private LocalDate lastUpdateDate;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}

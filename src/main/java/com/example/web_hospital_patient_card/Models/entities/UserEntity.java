package com.example.web_hospital_patient_card.Models.entities;

import com.example.web_hospital_patient_card.Models.dto.RecoveryPeriodSicknessDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//@SqlResultSetMappings(value = {
//        @SqlResultSetMapping(name = "sicknessRecoveryPeriodDTO", classes = {
//                @ConstructorResult(columns = {
//                        @ConstructorResult()
//                        @ConstructorResult()
//                },targetClass = RecoveryPeriodSicknessDTO.class)
//        })
//})
@Data
@Entity
@Table(name = "user_data_table")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "father_name")
    private String fatherName;

    private LocalDate dateOfBirth;

    @OneToMany(targetEntity = RecoveryPeriod.class,fetch = FetchType.LAZY)
    private List<RecoveryPeriod> recoveryPeriods;

    @JoinTable(name = "sickness_user",joinColumns = {
            @JoinColumn(),
            @JoinColumn()
    })
    @ManyToMany(targetEntity = SicknessEntity.class,fetch = FetchType.LAZY)
    private List<SicknessEntity> sicknessList;


    private long doctorId;

    private boolean isDoctor;

    private boolean isAdmin;

}

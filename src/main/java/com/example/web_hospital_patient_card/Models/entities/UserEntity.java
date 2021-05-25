package com.example.web_hospital_patient_card.Models.entities;

import com.example.web_hospital_patient_card.Models.dto.RecoveryPeriodSicknessDTO;
import com.example.web_hospital_patient_card.Models.roles.Role;
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
@Table(name = "user_data")
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

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(targetEntity = RecoveryPeriod.class,fetch = FetchType.LAZY)
    private List<RecoveryPeriod> recoveryPeriods;

    @JoinTable(name = "sickness_user",joinColumns = {
            @JoinColumn(name = "sickness_id", foreignKey = @ForeignKey(name = "id"), table = "sickness"),
            @JoinColumn(name = "user_id",referencedColumnName = "id")
    })
    @ManyToMany(targetEntity = SicknessEntity.class,fetch = FetchType.LAZY)
    private List<SicknessEntity> sicknessList;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

}

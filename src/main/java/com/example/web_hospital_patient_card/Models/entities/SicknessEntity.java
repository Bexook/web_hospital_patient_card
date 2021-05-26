package com.example.web_hospital_patient_card.Models.entities;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sickness")
public class SicknessEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sickness_name")
    private String name;

    @ManyToMany(targetEntity = MedicineEntity.class,mappedBy = "suitableFor")
    private List<MedicineEntity> suitableMedicine;


}

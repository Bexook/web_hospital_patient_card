package com.example.web_hospital_patient_card.Models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pills_data_table")
public class MedicineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(joinColumns = {
            @JoinColumn(),
            @JoinColumn()
    })
    private List<SicknessEntity> suitableFor;


}

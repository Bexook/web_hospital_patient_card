package com.example.web_hospital_patient_card.Models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medicine")
public class MedicineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "sickness_id", referencedColumnName = "id",table = "sickness"),
            foreignKey = @ForeignKey(name = "sk_foreign_key"),
            inverseJoinColumns =@JoinColumn(name = "medicine_id", referencedColumnName = "id"),
            inverseForeignKey = @ForeignKey(name = "md_foreign_key"))
    private List<SicknessEntity> suitableFor;


}

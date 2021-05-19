package com.example.web_hospital_patient_card.Models.entities;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sickness_data_table")
public class SicknessEntity {

    private long id;

    private String name;

    private List<MedicineEntity> suitableMedicine;

}

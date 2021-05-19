package com.example.web_hospital_patient_card.Models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pills_data_table")
public class MedicineEntity {

    private long id;

    private String name;

    private List<SicknessEntity> suitableFor;


}

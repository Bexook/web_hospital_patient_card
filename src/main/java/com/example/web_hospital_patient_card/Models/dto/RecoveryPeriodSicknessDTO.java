package com.example.web_hospital_patient_card.Models.dto;

import com.example.web_hospital_patient_card.Models.entities.RecoveryPeriod;
import com.example.web_hospital_patient_card.Models.entities.SicknessEntity;
import lombok.Data;

@Data
public class RecoveryPeriodSicknessDTO {

    private RecoveryPeriod recoveryPeriod;
    private SicknessEntity sickness;

}

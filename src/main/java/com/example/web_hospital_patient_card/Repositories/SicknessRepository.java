package com.example.web_hospital_patient_card.Repositories;

import com.example.web_hospital_patient_card.Models.Sickness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SicknessRepository extends JpaRepository<Sickness,Long> {

    public Sickness getById(long id);

}

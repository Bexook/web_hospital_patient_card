package com.example.web_hospital_patient_card.Repositories;

import com.example.web_hospital_patient_card.Models.Pill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PillRepository extends JpaRepository<Pill,Long> {

    public Pill findByName(String name);

}

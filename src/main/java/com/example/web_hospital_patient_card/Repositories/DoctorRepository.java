package com.example.web_hospital_patient_card.Repositories;

import com.example.web_hospital_patient_card.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {


    public Doctor getById(long id);

}

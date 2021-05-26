package com.example.web_hospital_patient_card.Repositories;

import com.example.web_hospital_patient_card.Models.entities.AccountDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDataRepository extends JpaRepository<AccountDataEntity,Long> {

    AccountDataEntity findById(long id);

}

package com.example.web_hospital_patient_card.mapper;

import com.example.web_hospital_patient_card.Models.dto.UserAccountDataDTO;
import com.example.web_hospital_patient_card.Models.dto.UserDTO;
import com.example.web_hospital_patient_card.Models.entities.AccountDataEntity;
import com.example.web_hospital_patient_card.Models.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserEntityToUserDTOMapper {
    @Mappings(value = {
            @Mapping(target = "id",source = "entity.id"),
            @Mapping(target = "email",source = "entity.email"),
            @Mapping(target = "phoneNumber",source = "entity.phoneNumber"),
            @Mapping(target = "password",source = "entity.password"),
            @Mapping(target = "role",source = "entity.role"),
    })
    UserDTO userEntityToUserDTO(UserEntity userEntity);


    //TODO create mapping for this classes
//
//    @Mapping(defaultValue = {
//            @Mapping()
//    })
    UserAccountDataDTO userEntityToUserAccountEntityDTO(UserEntity userEntity, AccountDataEntity account);
}

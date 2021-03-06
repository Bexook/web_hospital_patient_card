package com.example.web_hospital_patient_card.Services.RepoService;

import com.example.web_hospital_patient_card.Models.User;
import com.example.web_hospital_patient_card.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRepoServiceClass {


    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addNewUser(User user){
        if(user!=null&&!exists(user)){
            userRepository.save(user);
        }
    }


    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,readOnly = true)
    public User getSingleUserEmail(String email){
        return userRepository.findByEmail(email);
    }


    private boolean exists(User user){
        return userRepository.findByEmail(user.getEmail()) != null;
    }



    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUser(User user) {
        userRepository.save(user);
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW,readOnly = true)
    public User getUserById(long id){
        return userRepository.findById(id);
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteUser(String email){
        userRepository.delete( userRepository.findByEmail(email));
    }
}

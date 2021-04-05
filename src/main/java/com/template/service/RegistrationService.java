package com.template.service;
import com.template.entity.UserEntity;
import com.template.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService{
    @Autowired
    private  RegistrationRepository registrationRepository;
    public UserEntity saveUser(UserEntity user){ return registrationRepository.save(user);}

    public UserEntity fetchUserByEmail(String email){
       return registrationRepository.findByEmail(email);
    }

}

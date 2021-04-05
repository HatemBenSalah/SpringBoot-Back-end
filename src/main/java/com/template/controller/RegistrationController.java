package com.template.controller;

import java.util.List;

import javax.validation.Valid;

import com.template.entity.UserEntity;
import com.template.repositories.RegistrationRepository;
import com.template.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/UserController")
public class RegistrationController {

    @Autowired
    private RegistrationService service;
    @PostMapping("/register")
    public UserEntity registerUser (@RequestBody UserEntity user) throws Exception {
        String tempEmail=user.getEmail();
        if(tempEmail!=null && !"".equals(tempEmail)){
          UserEntity userobj =service.fetchUserByEmail(tempEmail);
          if (userobj!= null){
              throw new Exception("user with email "+tempEmail+" is already exist");
          }
        }
        UserEntity userobj=null;
        userobj=service.saveUser(user);
        return userobj;
    }


    }



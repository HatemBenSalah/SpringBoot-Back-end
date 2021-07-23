package com.hms.controller;
import javax.validation.Valid;
import com.hms.entity.UserEntity;
import com.hms.interfaces.User;
import com.hms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.hms.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/UserController")
public class UserController implements User {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/getUser")

    public UserEntity getUser(@Valid @RequestBody UserEntity userEntity)throws ResourceNotFoundException {
        UserEntity user = userRepository.findById(userEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: "));
               return user;
    }
    @PostMapping("/updateUser")
    public Boolean updateUser(@Valid @RequestBody UserEntity userEntity) throws ResourceNotFoundException {
        UserEntity user = userRepository.findById(userEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id  "));
        try {
            user.setEmail(userEntity.getEmail());
            user.setLastName(userEntity.getLastName());
            user.setFirstName(userEntity.getFirstName());
            user.setPhone(userEntity.getPhone());
            user.setAdresse(userEntity.getAdresse());
            user.setCin(userEntity.getCin());
           user. setPassword(encoder.encode(userEntity.getPassword()));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}

package com.template.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.template.entity.UserEntity;
import com.template.repositories.UserRepository;
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
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getUser")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/UserEntity/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable(value = "id") Integer userId)
            throws ResourceNotFoundException {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }


    @GetMapping("/UserEntity/{CIN}")
    public ResponseEntity<UserEntity> getUserByCIN(@PathVariable(value = "CIN") Integer userCin)
            throws ResourceNotFoundException {
        UserEntity user = userRepository.findById(userCin)
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this CIN :: " + userCin));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/createUser")
    public UserEntity createUser(@Valid @RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @PostMapping("/updateUser")
    public Boolean updateUser(@Valid @RequestBody UserEntity UserDetails) throws ResourceNotFoundException {
        UserEntity user = userRepository.findById(UserDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: "));
        try {
            user.setEmail(UserDetails.getEmail());
            user.setLastName(UserDetails.getLastName());
            user.setFirstName(UserDetails.getFirstName());
            user.setCIN(UserDetails.getCIN());
            user.setAdresse(UserDetails.getAdresse());
            user.setPassword(UserDetails.getPassword());
            user.setPhone(UserDetails.getPhone());


            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @PostMapping("/deleteUser")
    public Map<String, Boolean> deleteUser(@Valid @RequestBody Integer userId)
            throws ResourceNotFoundException {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
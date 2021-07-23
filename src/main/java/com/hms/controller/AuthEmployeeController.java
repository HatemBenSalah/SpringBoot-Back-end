package com.hms.controller;
import javax.validation.Valid;
import com.hms.entity.*;
import com.hms.interfaces.AuthEmployee;
import com.hms.repositories.EmployeeRepository;
import com.hms.repositories.UserRepository;
import com.hms.request.LoginRequest;
import com.hms.request.SignupRequest;
import com.hms.response.JwtResponse;
import com.hms.response.MessageResponse;
import com.hms.security.jwt.JwtUtils;
import com.hms.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/authemployee")
public class AuthEmployeeController implements AuthEmployee {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity
                .ok(new JwtResponse(
                        jwt,
                        userDetails.getId(),
                        userDetails.getEmail(),
                        userDetails.getRoles(),
                        userDetails.getPhone(),
                        userDetails.getFirstName(),
                        userDetails.getLastName(),
                        userDetails.getCin(),
                        userDetails.getAdresse(),
                         userDetails.getEmployeservice()));
    }

    @PostMapping("/signup")
    public Boolean registerEmployee(@Valid @RequestBody SignupRequest signUpRequest) {
        if (employeeRepository.existsByEmail(signUpRequest.getEmail())) {
            return false;
        }

        // Create new user's account
        EmployeeEntity employee = new EmployeeEntity(
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()), signUpRequest.getRoles(), signUpRequest.getPhone(), signUpRequest.getFirstName(),
                signUpRequest.getLastName(), signUpRequest.getCin(), signUpRequest.getAdresse(),signUpRequest.getEmployeservice());
        employeeRepository.save(employee);
        return true;
    }


}


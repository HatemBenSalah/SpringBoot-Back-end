package com.hms.interfaces;

import com.hms.request.LoginRequest;
import com.hms.request.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AuthAdmin {
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest);
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest);
}

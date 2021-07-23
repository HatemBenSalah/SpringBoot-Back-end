package com.hms.interfaces;

import com.hms.entity.UserEntity;
import com.hms.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface User {
    public UserEntity getUser(@Valid @RequestBody UserEntity userEntity)throws ResourceNotFoundException;
    public Boolean updateUser(@Valid @RequestBody UserEntity userEntity) throws ResourceNotFoundException;
}

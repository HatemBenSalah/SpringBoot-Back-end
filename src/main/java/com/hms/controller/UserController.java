
package com.hms.controller;

        import java.util.List;
        import java.util.Optional;

        import javax.validation.Valid;

        import com.hms.entity.CommandeEntity;
        import com.hms.entity.UserEntity;
        import com.hms.repositories.UserRepository;
        import com.hms.security.service.UserDetailsImpl;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
        import org.springframework.web.bind.annotation.*;
        import com.hms.exception.ResourceNotFoundException;
@RestController
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/getUser")

    public UserEntity getUser(@Valid @RequestBody UserEntity userEntity)throws ResourceNotFoundException {
        UserEntity user = userRepository.findById(userEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: "));
        return user;
    }






    @PostMapping("/updateUser")
    public Boolean updateUser(@Valid @RequestBody UserEntity userEntity) throws ResourceNotFoundException {
        UserEntity user = userRepository.findById(userEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: "));
        try {
            user.setEmail(userEntity.getEmail());
            user.setLastName(userEntity.getLastName());
            user.setFirstName(userEntity.getFirstName());
            user.setPhone(userEntity.getPhone());
            user.setAdresse(userEntity.getAdresse());
            user.setCin(userEntity.getCin());
            user.setPassword(userEntity.getPassword());
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


}

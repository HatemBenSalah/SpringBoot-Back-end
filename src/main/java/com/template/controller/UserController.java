package com.template.controller;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.entity.RolesEntity;
import com.template.entity.UserEntity;
import com.template.exception.ResourceNotFoundException;
import com.template.repositories.UserRepository;

@RestController
@RequestMapping("/userController")
public class UserController {
	
	@Autowired
	private static UserRepository userRep;
		
	@GetMapping(path="/getNonDeletedUsers")
	public List<UserEntity> getNonDeletedUsers() {
		return userRep.findByisDeleted(false);
	}
	
	@GetMapping(path="/getAllUsers")
	public List<UserEntity> getAllUsers() {
		return userRep.findAll();
	}
	
	@GetMapping(path="/getUsersByRole")
	public List<UserEntity> getUsersByRole(@Valid @RequestBody RolesEntity role) {
		return userRep.findByrole(role);
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<UserEntity> getUserByID(@PathVariable(value="id") Long userId)
	throws ResourceNotFoundException{
		UserEntity user = userRep.findById(userId)
						.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :"+userId));
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<UserEntity> login(@PathVariable(value="email") String userEmail , @PathVariable(value="password") String userPassword)
	throws ResourceNotFoundException{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		List<UserEntity> user = userRep.findByemail(userEmail);
		if(user.size() != 0) {
			for(int i=0; i<user.size(); i++) {
				if(passwordEncoder.matches(userPassword, user.get(i).getPassword())) {
					if(user.get(i).getIsDeleted() == true) {
						return  ResponseEntity.ok().header("userResult", "deleted account").body(null);
					}else return ResponseEntity.ok().body(user.get(i));
				}
			}	
			return  ResponseEntity.ok().header("userResult", "no password matches").body(null);
		}else return  ResponseEntity.ok().header("userResult", "no user matches").body(null);
		
	}
	
	@PostMapping("/addUser")
	public UserEntity addUser(@Valid @RequestBody UserEntity user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setIsDeleted(false);
		return userRep.save(user);
	}
	
	@PostMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value="id") Long userId)
			throws ResourceNotFoundException {
		UserEntity user = userRep.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this Id :"+userId));
		user.setIsDeleted(true);
		userRep.save(user);
		return "success";
	}
	
	@PostMapping("/restoreUser/{id}")
	public String restoreUser(@PathVariable(value="id") Long userId)
			throws ResourceNotFoundException {
		UserEntity user = userRep.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this Id :"+userId));
		user.setIsDeleted(false);
		userRep.save(user);
		return "success";
	}
	
	@PutMapping("/editUser/{id}")
	public ResponseEntity<UserEntity> editUser(@PathVariable(value="id") Long UserId, @Valid @RequestBody UserEntity userDetails)
	throws ResourceNotFoundException{
		UserEntity user = userRep.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this Id :"+UserId));
		user.setEmail(userDetails.getEmail());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		final UserEntity updatedUser = userRep.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	@PutMapping("/editRoleForUser/{id}")
	public ResponseEntity<UserEntity> editRoleForUser(@PathVariable(value="id") Long UserId, @Valid @RequestBody UserEntity userDetails)
	throws ResourceNotFoundException{
		UserEntity user = userRep.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this Id :"+UserId));
		RolesEntity role = new RolesEntity();
		role.setId(userDetails.getRole().getId());
		role.setDescription(userDetails.getRole().getDescription());
		user.setRole(role);
		final UserEntity updatedUser = userRep.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	
}
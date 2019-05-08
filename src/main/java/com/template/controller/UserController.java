package com.template.controller;

import java.util.Date;
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
	private UserRepository userRep;
		
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
	public ResponseEntity<UserEntity> getUserByID(@PathVariable(value="id") Integer userId)
	throws ResourceNotFoundException{
		UserEntity user = userRep.findById(userId)
						.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :"+userId));
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/login")
	public ResponseEntity<UserEntity> login(@RequestBody UserEntity userLogs)
	throws ResourceNotFoundException{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		List<UserEntity> user = userRep.findByemail(userLogs.getEmail());
		if(user.size() != 0) {
			for(int i=0; i<user.size(); i++) {
				if(passwordEncoder.matches(userLogs.getPassword(), user.get(i).getPassword())) {
					if(user.get(i).getIsDeleted() == true) {
						return  ResponseEntity.ok().header("userResult", "deleted account").body(null);
					}else {
						user.get(i).setLastLogin(new Date()+"");
						userRep.save(user.get(i));
						return ResponseEntity.ok().body(user.get(i));
					}
				}
			}	
			return  ResponseEntity.ok().header("userResult", "no password matches").body(null);
		}else return  ResponseEntity.ok().header("userResult", "no user matches").body(null);
		
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<UserEntity> addUser(@Valid @RequestBody UserEntity user)
			throws ResourceNotFoundException {
		List<UserEntity> UserExist = userRep.findByemail(user.getEmail());
		if(UserExist.size() != 0) {
		return ResponseEntity.ok().header("Already exist", "this user already exist").body(null);
		}else {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setIsDeleted(false);
		user.setCreatedOn(new Date()+"");
		userRep.save(user);
		return ResponseEntity.ok().body(user);
		}
	}
	
	@PostMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value="id") Integer userId)
			throws ResourceNotFoundException {
		UserEntity user = userRep.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this Id :"+userId));
		user.setIsDeleted(true);
		user.setUpdatedOn(new Date()+"");
		userRep.save(user);
		return "success";
	}
	
	@PostMapping("/restoreUser/{id}")
	public String restoreUser(@PathVariable(value="id") Integer userId)
			throws ResourceNotFoundException {
		UserEntity user = userRep.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this Id :"+userId));
		user.setIsDeleted(false);
		user.setUpdatedOn(new Date()+"");
		userRep.save(user);
		return "success";
	}
	
	@PutMapping("/editUser/{id}")
	public ResponseEntity<UserEntity> editUser(@PathVariable(value="id") Integer UserId, @Valid @RequestBody UserEntity userDetails)
	throws ResourceNotFoundException{
		UserEntity user = userRep.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this Id :"+UserId));
		user.setEmail(userDetails.getEmail());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setUpdatedOn(new Date()+"");
		final UserEntity updatedUser = userRep.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	@PutMapping("/editRoleForUser/{id}")
	public ResponseEntity<UserEntity> editRoleForUser(@PathVariable(value="id") Integer UserId, @Valid @RequestBody UserEntity userDetails)
	throws ResourceNotFoundException{
		UserEntity user = userRep.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this Id :"+UserId));
		RolesEntity role = new RolesEntity();
		role.setId(userDetails.getRole().getId());
		role.setDescription(userDetails.getRole().getDescription());
		user.setRole(role);
		user.setUpdatedOn(new Date()+"");
		final UserEntity updatedUser = userRep.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	
}
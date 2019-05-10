package com.template.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.template.repositories.RoleRepository;
import com.template.repositories.UserRepository;

@RestController
@RequestMapping("/rolesController")
public class RolesController {
	
	
	@Autowired
	private RoleRepository roleRep;
	
	@Autowired
	private UserRepository userRep;
	
	@GetMapping(path="/getAllRoles")
	public List<RolesEntity> getAllRoles(){
		return roleRep.findAll();
	}
	
	@GetMapping(path="/getRoleByDescription")
	public List<RolesEntity> getRoleByDiscription(@Valid @RequestBody RolesEntity role) {
		return roleRep.findBydescription(role.getDescription());
	}
	
	@PostMapping("/addRole")
	public RolesEntity addRole(@Valid @RequestBody RolesEntity role) {
		role.setIsDeleted(false);
		role.setCreatedOn(new Date()+"");
		return roleRep.save(role);
	}
	
	@PutMapping("/editRole/{id}")
	public ResponseEntity<RolesEntity> editUser(@PathVariable(value="id") Integer roleId, @Valid @RequestBody RolesEntity roleDetails)
	throws ResourceNotFoundException{
		RolesEntity role = roleRep.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this Id :"+roleId));
		role.setDescription(roleDetails.getDescription());
		role.setUpdatedOn(new Date()+"");
		final RolesEntity updatedRole = roleRep.save(role);
		return ResponseEntity.ok(updatedRole);
	}
	
	@PutMapping("/deleteRole")
	public String deleteRole(@RequestBody RolesEntity role)
			throws ResourceNotFoundException {
		RolesEntity roleExist = roleRep.findById(role.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No Role found with this Id:"+role.getId()) );
		roleExist.setIsDeleted(true);
		roleExist.setUpdatedOn(new Date()+"");
		roleRep.save(roleExist);
		List<UserEntity> user = userRep.findByrole(role);
		for(int i=0; i<user.size(); i++) {
			user.get(i).setIsDeleted(true);
			userRep.save(user.get(i));
		}
		return "success";
	}

}

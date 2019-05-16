package com.template.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.entity.PathEntity;
import com.template.exception.ResourceNotFoundException;
import com.template.repositories.PathRepository;

@RestController
@RequestMapping("/pathController")
public class PathController {
	
	@Autowired
	private PathRepository pathRep;
	
	@GetMapping(path="/getAll")
	public List<PathEntity> getAll() {
		return pathRep.findAll();
	}
	
	@PutMapping(path="/setDbParams")
	public PathEntity setDbParams(@RequestBody PathEntity newPath) 
	throws ResourceNotFoundException{
		PathEntity path = pathRep.findById(1)
				.orElseThrow(() -> new ResourceNotFoundException("the Path Table must contain the first row with the ID =1"));
		path.setDbPassword(newPath.getDbPassword());
		path.setDbUrl(newPath.getDbUrl());
		path.setDbUser(newPath.getDbUser());
		path.setUpdatedOn(new Date()+"");
		pathRep.save(path);
		return path;
	}

}

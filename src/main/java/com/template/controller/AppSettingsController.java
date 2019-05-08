package com.template.controller;

import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.template.entity.AppSettings;
import com.template.exception.ResourceNotFoundException;
import com.template.repositories.AppSettingsRepository;

@RestController
@RequestMapping("/AppSettingsController")
public class AppSettingsController {

	@Autowired
	AppSettingsRepository settings;
	
	@PutMapping(path="/updateTimeZone/{timeZone}")
	public ResponseEntity<AppSettings> updateTimeZone(@PathVariable(value="timeZone") String timeZone)
			throws ResourceNotFoundException{
		AppSettings exist = settings.findById(1)
				.orElseThrow(() -> new ResourceNotFoundException("Make sure you already presetted a time zone in app_settings table , first row"));
		exist.setTimeZone(timeZone);
		exist.setUpdatedOn(new Date()+"");
		settings.save(exist);
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
		return ResponseEntity.ok(exist);
	}
	
}

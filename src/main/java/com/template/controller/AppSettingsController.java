package com.template.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.template.entity.AppSettingsEntity;
import com.template.exception.FileStorageException;
import com.template.exception.ResourceNotFoundException;
import com.template.repositories.AppSettingsRepository;


@RestController
@RequestMapping("/AppSettingsController")
public class AppSettingsController {

	@Autowired
	AppSettingsRepository settings;
	
	
	@PutMapping(path="/updateSettings")
	public ResponseEntity<AppSettingsEntity> updateSettings(@Valid @RequestBody AppSettingsEntity newSetting)
	throws ResourceNotFoundException {
		AppSettingsEntity exist = settings.findById(1)
				.orElseThrow(() -> new ResourceNotFoundException("an error in appSettingController update settings: no previous settings found with this ID"));;
	exist.setCompanyName(newSetting.getCompanyName());
	exist.setCompanyEmail(newSetting.getCompanyEmail());
	exist.setUpdatedOn(new Date()+"");
	settings.save(exist);
	return ResponseEntity.ok(exist);
	}
	
	@PutMapping(path="/updateLogo")
	public ResponseEntity<AppSettingsEntity> updateLogo (@RequestParam("file") MultipartFile file)
	throws ResourceNotFoundException{
		try {
		AppSettingsEntity fileDb = settings.findById(1)
				.orElseThrow( () -> new ResourceNotFoundException("you better add first column in appSettingsEntity"));
		fileDb.setHasLogo(true);
		fileDb.setCompanyLogo(file.getBytes());
		fileDb.setLogoName(file.getOriginalFilename());
		fileDb.setLogoType(file.getContentType());
		fileDb.setUpdatedOn(new Date()+"");
		settings.save(fileDb);
		return ResponseEntity.ok(fileDb);
		}catch (IOException ex) {
			throw new FileStorageException("Could not store file , Please try again!", ex);
		}
	}
	
	@PutMapping(path="/updateTimeZone/{timeZone}")
	public ResponseEntity<AppSettingsEntity> updateTimeZone(@PathVariable(value="timeZone") String timeZone)
			throws ResourceNotFoundException{
		AppSettingsEntity exist = settings.findById(1)
				.orElseThrow(() -> new ResourceNotFoundException("Make sure you already presetted a time zone in app_settings table , first row"));
		exist.setTimeZone(timeZone);
		exist.setUpdatedOn(new Date()+"");
		settings.save(exist);
		//update the timeZone for all the app
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
		return ResponseEntity.ok(exist);
	}
	
	@PutMapping(path="/updateEmail")
	public ResponseEntity<AppSettingsEntity> updateEmail(@RequestBody AppSettingsEntity newEmail)
	throws ResourceNotFoundException{
		AppSettingsEntity exist = settings.findById(1)
				.orElseThrow(() -> new ResourceNotFoundException("Make sure you already presetted an Email in app_settings table , first row"));
		exist.setCompanyEmail(newEmail.getCompanyEmail());
		exist.setUpdatedOn(new Date()+"");
		settings.save(exist);
		return ResponseEntity.ok(exist);
	}
	
	@PutMapping(path="/updateName")
	public ResponseEntity<AppSettingsEntity> updateName(@RequestBody AppSettingsEntity newName)
	throws ResourceNotFoundException{
		AppSettingsEntity exist = settings.findById(1)
				.orElseThrow(() -> new ResourceNotFoundException("Make sure you already presetted an Email in app_settings table , first row"));
		exist.setCompanyName(newName.getCompanyName());
		exist.setUpdatedOn(new Date()+"");
		settings.save(exist);
		return ResponseEntity.ok(exist);
	}
	
	@GetMapping(path="/getSettings")
	public List<AppSettingsEntity> getSettings(){
		return settings.findAll();
	}
}

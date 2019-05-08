package com.template;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.template.repositories.AppSettingsRepository;

@SpringBootApplication
public class TemplateApp {
	
	@Autowired
	AppSettingsRepository settings;
	
	 @PostConstruct
     void started() {
		String timeZone = settings.findById(1).get().getTimeZone();
		if(timeZone == null || timeZone == "") {
			 TimeZone.setDefault(TimeZone.getTimeZone("PST8PDT"));
		}else {
			TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
		}
     }

	public static void main(String[] args) {
		
		SpringApplication.run(TemplateApp.class, args);
	}

}

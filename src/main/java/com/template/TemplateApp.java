package com.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.template.repositories.AppSettingsRepository;
import com.template.repositories.PathRepository;

@SpringBootApplication
public class TemplateApp {
	
	@Autowired
	AppSettingsRepository settings;
	
	@Autowired
	PathRepository pathRep;
	
	 @PostConstruct
     void started() {
		 //Set time zone as parametred
		String timeZone = settings.findById(1).get().getTimeZone();
		if(timeZone == null || timeZone == "") {
			 TimeZone.setDefault(TimeZone.getTimeZone("PST8PDT"));
		}else {
			TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
		}
		
		//Set the DB connection
		String url = pathRep.findById(1).get().getDbUrl();
		String user = pathRep.findById(1).get().getDbUser();
		String password = pathRep.findById(1).get().getDbPassword();
		try {
			Connection conn = DriverManager.getConnection(url , user , password );
			 Statement statement = conn.createStatement();
			 //this is just an example of a query from another database: read doc "Path" section to know more
			 ResultSet resultSet = statement.executeQuery("SELECT * FROM public.pbusers");
			 while (resultSet.next()) {
	                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("email"), resultSet.getString("mot_de_passe"));
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
     }

	public static void main(String[] args) {
		SpringApplication.run(TemplateApp.class, args);
	}

}

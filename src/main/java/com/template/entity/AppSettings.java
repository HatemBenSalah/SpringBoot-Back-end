package com.template.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_SETTINGS")
public class AppSettings {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="TIMEZONE")
	private String timeZone;
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@Column(name="COMPANY_LOGO")
	private byte[] companyLogo;
	
	@Column(name="LOGO_NAME")
	private String logoName;
	
	@Column(name="HAS_LOGO")
	private Boolean hasLogo;
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public byte[] getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(byte[] companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getLogoName() {
		return logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}

	public Boolean getHasLogo() {
		return hasLogo;
	}

	public void setHasLogo(Boolean hasLogo) {
		this.hasLogo = hasLogo;
	}

	@Column(name="UPDATED_ON")
	private String updatedOn;


	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
}

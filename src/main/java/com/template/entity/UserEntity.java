package com.template.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="UTILISATEUR")
public class UserEntity  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="ADRESSE")
	private String adresse;
	@Column(name="PHONE")
	private String phone;
	//Encrypted using bycript
	@Column(name="PASSWORD")
	private String password;
	@Column(name="CIN")
	private String CIN;
	public UserEntity(String firstNamee, String lastNamee, String emaill, String adressee, String phonee ,String passwordd , int idd , String cin)
	{
		super();
		firstName=firstNamee;
		lastName=lastNamee;
		email=emaill;
		adresse=adressee;
		password=passwordd;
		phone=phonee;
		id=idd;
		CIN=cin;

	}
	public UserEntity()
	{

	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdresse() {return adresse;	}
	public void setAdresse(String adresse) {this.adresse = adresse;	}
	public String getCIN() {return CIN;	}
	public void setCIN(String CIN) {this.CIN = CIN;	}
	public String getPhone() {return phone;	}
	public void setPhone(String phone) {this.phone = phone;	}


}

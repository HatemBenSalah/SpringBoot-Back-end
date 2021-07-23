package com.hms.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="EMPLOYEES")

public class EmployeeEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "EMPLOYE_NAME")
    private String firstName;
    @Column(name="EMPLOYE_LASTNAME")
    private String lastName;
    @Column(name= "EMPLOYE_EMAIL")
    private String email;
    @Column(name="EMPLOYE_SERVICE")
    private String employeservice;
    @Column(name="EMPLOYE_PHONE")
    private String phone;
    @Column(name="EMPLOYE_CIN")
    private String cin;
    @Column(name="EMPLOYE_ADRESSE")
    private String adresse;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="ROLES")
    private String roles;


    @OneToMany(mappedBy = "employee")
    private List<ClaimEntity> claimEntityList  ;


    @OneToMany(mappedBy = "employee")
    private List<CommandeEntity> commandeEntityList  ;
    @OneToMany(mappedBy = "employee")
    private List<InterventionEntity> interventionEntityList  ;

    public EmployeeEntity(){};
    public EmployeeEntity(String email, String password,String roles
            , String phone,String firstName,String lastName, String cin, String adresse ,String employeservice) {

        this.email = email;
        this.password = password;
        this.roles =roles;
        this.phone=phone;
        this.firstName=firstName;
        this.lastName=lastName;
        this.cin=cin;
        this.adresse=adresse;
        this.employeservice=employeservice;
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

    public String getEmployeservice() {
        return employeservice;
    }

    public void setEmployeservice(String employeservice) {
        this.employeservice = employeservice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


    public Long  getId() {return id;}

    public void setId(Long id) {this.id = id;}



    public void setClaimEntityList(List<ClaimEntity> claimEntityList) {
        this.claimEntityList = claimEntityList;
    }

    public void setInterventionEntityList(List<InterventionEntity> interventionEntityList) {
        this.interventionEntityList = interventionEntityList;
    }

    public void setCommandeEntityList(List<CommandeEntity> commandeEntityList) {
        this.commandeEntityList = commandeEntityList;
    }

  }

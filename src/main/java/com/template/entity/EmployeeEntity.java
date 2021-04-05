package com.template.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="EMPLOYEES")

public class EmployeeEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "EMPLOYE_NAME")
    private String employeName;
    @Column(name="EMPLOYE_LASTNAME")
    private String employeLastname;
    @Column(name= "EMPLOYE_EMAIL")
    private String employeemail;
    @Column(name="EMPLOYE_SERVICE")
    private String employeservice;
    @Column(name="EMPLOYE_PHONE")
    private String employephone;
    @Column(name="EMPLOYE_CIN")
    private String employecin;
    @Column(name="EMPLOYE_CODE")
    private String employecode;

    public Integer  getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getEmployeName() {return employeName;}

    public void setEmployeName(String employeName) {this.employeName = employeName;}

    public String getEmployeLastname() {return employeLastname;}

    public void setEmployeLastname(String employeLastname) {this.employeLastname = employeLastname;}

    public String getEmployeemail() {return employeemail;}

    public void setEmployeemail(String employeemail) {this.employeemail = employeemail;}

    public String getEmployeservice() {return employeservice;}

    public void setEmployeservice(String employeservice) {this.employeservice = employeservice;}

    public String getEmployephone() {return employephone;}

    public void setEmployephone(String employephone) {this.employephone = employephone;}

    public String getEmployecin() {return employecin;}

    public void setEmployecin(String employecin) {this.employecin = employecin;}

    public String getEmployecode() {return employecode;}

    public void setEmployecode(String employecode) {this.employecode = employecode;}

}

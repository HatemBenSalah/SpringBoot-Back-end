package com.hms.request;
import javax.validation.constraints.*;
public class SignupRequest {

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    private String phone;
    private String firstName;
    private String lastName;
    private String cin;
    private String adresse;
    private String roles;
    private String employeservice;

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone; }
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {  return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName; }
    public String getCin() { return cin;}
    public void setCin(String cin) {this.cin = cin;}
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) {this.adresse = adresse;}
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
    public String getRoles() { return this.roles; }
    public void setRole(String roles) {
        this.roles = roles;
    }
    public String getEmployeservice() { return employeservice;}
    public void setEmployeservice(String employeeservice) {this.employeservice = employeeservice; }
}

package com.hms.security.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.hms.entity.AdminEntity;
import com.hms.entity.EmployeeEntity;
import com.hms.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String email;
    private String roles;
    private String phone;
    private String firstName;
    private String lastName;
    private String cin;
    private String adresse;
    private String employeservice;
    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String email, String password, String roles,
                           String phone, String firstName, String lastName, String adresse, String cin) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresse = adresse;
        this.cin = cin;

    }
    public UserDetailsImpl(Long id, String email, String password, String roles,
                           String phone, String firstName, String lastName, String adresse, String cin,String employeeservice) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresse = adresse;
        this.cin = cin;
        this.employeservice=employeeservice;
    }



    public static UserDetailsImpl build(UserEntity user) {

        return new UserDetailsImpl(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getRoles(), user.getPhone(), user.getFirstName(), user.getLastName(), user.getAdresse(), user.getCin());
    }
    public static UserDetailsImpl build(AdminEntity admin) {

        return new UserDetailsImpl(
                admin.getId(),
                admin.getEmail(),
                admin.getPassword(),
                admin.getRoles(), admin.getPhone(), admin.getFirstName(), admin.getLastName(), admin.getAdresse(), admin.getCin());
    }
    public static UserDetailsImpl build(EmployeeEntity user) {

        return new UserDetailsImpl(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getRoles(), user.getPhone(), user.getFirstName(), user.getLastName(), user.getAdresse(), user.getCin(),user.getEmployeservice());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    public String getEmployeservice() {
        return employeservice;
    }

    public void setEmployeservice(String employeeservice) {
        this.employeservice = employeeservice;
    }

    @Override
    public String getUsername() {    return username;  }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}

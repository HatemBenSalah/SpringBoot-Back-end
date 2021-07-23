package com.hms.entity;



        import javax.persistence.*;

@Entity
@Table(	name = "admin",
        uniqueConstraints = {

                @UniqueConstraint(columnNames = "email")
        })
public class AdminEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private String firstName;
    private String lastName;
    private String cin;
    private String adresse;
    private String Roles;
    private String email;
    private String password;

    public AdminEntity(){};
    public AdminEntity(String email, String password,String roles
            , String phone,String firstName,String lastName, String cin, String adresse ) {

        this.email = email;
        this.password = password;
        this.Roles=roles;
        this.phone=phone;
        this.firstName=firstName;
        this.lastName=lastName;
        this.cin=cin;
        this.adresse=adresse;
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

    public String getRoles() {
        return Roles;
    }

    public void setRoles(String role) {
        this.Roles = role;
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



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


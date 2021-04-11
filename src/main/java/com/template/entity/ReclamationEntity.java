package com.template.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RECLAMATION")
public class ReclamationEntity  {
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
    @Column(name="NAMESERVICE")
    private String nameservice;
    @Column(name="RECLAMATIONDESCRIPTION")
    private String reclamationdescription;


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
    public String getNameservice() {return nameservice;}
    public void setNameservice(String nameservice) {this.nameservice = nameservice;}
    public String getAdresse() {return adresse;	}
    public void setAdresse(String adresse) {this.adresse = adresse;	}
    public String getReclamationdescription() {return reclamationdescription;	}
    public void setReclamationdescription(String reclamationdescription) {this.reclamationdescription = reclamationdescription;	}
    public String getPhone() {return phone;	}
    public void setPhone(String phone) {this.phone = phone;	}


}

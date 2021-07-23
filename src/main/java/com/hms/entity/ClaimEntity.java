package com.hms.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CLAIM")
public class ClaimEntity {
    @ManyToOne
    private UserEntity user;
    public void setCommande(CommandeEntity commande) {
        this.commande = commande;
    }
    @ManyToOne
    private CommandeEntity commande;
    @ManyToOne
    private EmployeeEntity employee;
    @OneToMany(mappedBy = "claim")
    private List<InterventionEntity> interventionEntityList  ;
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
    @Column(name="CLAIMDESCRIPTION")
    private String claimdescription;
    @Column(name="STATE")
    private String state;
    @Column(name = "INTERVENTION_STATE")
    private String interventionstate;
    @Column(name="DATE_DEMMANDE")
    private String datedemmande;
    public String getAcceptationdate() {
        return acceptationdate;
    }
    public void setAcceptationdate(String acceptationdate) {
        this.acceptationdate = acceptationdate;
    }
    @Column(name = "DATE_ACCEPTATION")
    private String acceptationdate;
    public String getInterventionstate() { return interventionstate; }
    public void setInterventionstate(String interventionstate) {this.interventionstate = interventionstate;}
    public void setCommandeEntity(CommandeEntity commandeEntity) {this.commande = commandeEntity; }
    public void setUser(UserEntity user) {this.user = user;}
    public void setEmployee(EmployeeEntity employee) {this.employee = employee; }
    public EmployeeEntity getEmployee() {return employee;}
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
    public String getClaimdescription() {return claimdescription;	}
    public void setClaimdescription(String reclamationdescription) {this.claimdescription = reclamationdescription;	}
    public String getPhone() {return phone;	}
    public void setPhone(String phone) {this.phone = phone;	}
    public String getDatedemmande() {return datedemmande;}
    public void setDatedemmande(String datedemmande) {this.datedemmande = datedemmande;}
    public String getState() {return state;}
    public void setInterventionEntityList(List<InterventionEntity> interventionEntityList) {this.interventionEntityList = interventionEntityList; }
    public void setState(String state) {this.state = state;}
}

package com.hms.entity;
import javax.persistence.*;
@Entity
@Table(name = "INTERVENTION")
public class InterventionEntity {
    @ManyToOne
    private EmployeeEntity employee;
    @ManyToOne
    private CommandeEntity commande;
    @ManyToOne
    private ClaimEntity claim;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdIntervention;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "NAMESERVICE")
    private String nameservice;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PANNE_DESCRIPTION")
    private String pannedescription;
    @Column(name = "INTERVENTION_DESCRIPTION")
    private String interventiondescription;
    @Column(name = "INTERVENTION_STATE")
    private String interventionstate;
    @Column(name = "DATE_DEMMANDE")
    private String datedemmande;
    @Column(name = "DATE_ACCEPTATION")
    private String acceptationdate;
    @Column(name = "DATE_INTERVENTION")
    private String dateintervention;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdIntervention() {
        return IdIntervention;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setClaim(ClaimEntity claim) {this.claim = claim;}

    public void setCommande(CommandeEntity commande) {
        this.commande = commande;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setIdIntervention(Long idIntervention) {
        IdIntervention = idIntervention;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNameservice() {
        return nameservice;
    }

    public void setNameservice(String nameservice) {
        this.nameservice = nameservice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPannedescription() {
        return pannedescription;
    }

    public void setPannedescription(String pannedescription) {
        this.pannedescription = pannedescription;
    }

    public String getInterventiondescription() {
        return interventiondescription;
    }

    public void setInterventiondescription(String interventiondescription) {
        this.interventiondescription = interventiondescription;
    }

    public String getInterventionstate() {
        return interventionstate;
    }

    public void setInterventionstate(String interventionstate) {
        this.interventionstate = interventionstate;
    }

    public String getDatedemmande() {
        return datedemmande;
    }

    public void setDatedemmande(String datedemmande) {
        this.datedemmande = datedemmande;
    }

    public String getAcceptationdate() {
        return acceptationdate;
    }

    public void setAcceptationdate(String acceptationdate) {
        this.acceptationdate = acceptationdate;
    }

    public String getDateintervention() {
        return dateintervention;
    }

    public void setDateintervention(String dateintervention) {
        this.dateintervention = dateintervention;
    }


}

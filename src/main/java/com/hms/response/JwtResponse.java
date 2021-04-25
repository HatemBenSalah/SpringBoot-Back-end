package com.hms.response;

public class JwtResponse {
    private String token;
    private String type = "Bearer ";
    private Long id;

    private String email;
    private String roles;
    private String phone;
    private String firstName;
    private String lastName;
    private String cin;
    private String adresse;


    public JwtResponse(String accessToken, Long id,  String email, String roles , String phone,
                       String firstName, String lastName,String cin, String adresse)
    {
        this.token = accessToken;
        this.id = id;

        this.email = email;
        this.roles = roles;
        this.phone=phone;
        this.firstName=firstName;
        this.lastName=lastName;
        this.cin=cin;
        this.adresse=adresse;

    }


    public String getAccessToken() { return token; }

    public void setAccessToken(String accessToken) { this.token = accessToken; }

    public String getTokenType() {   return type; }

    public void setTokenType(String tokenType) {   this.type = tokenType;  }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getRoles() { return roles; }
}

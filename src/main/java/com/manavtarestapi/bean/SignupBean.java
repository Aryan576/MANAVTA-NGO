package com.manavtarestapi.bean;

import lombok.Data;

@Data
public class SignupBean {

    private int id;
   private String firstname;
    private String  lastname;
    private String phonenumber;
    private String email;
    private String address;
    private String dob;
    private  String password;
    private  String gender;
    private int roleid;

}

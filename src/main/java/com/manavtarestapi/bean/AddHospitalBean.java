package com.manavtarestapi.bean;


import lombok.Data;

@Data
public class AddHospitalBean {
    private  String hospitalname,location, hospitaladdress, numberbeds,pincode,hospitalphonenumber,lat,log;
    private int hospitalid;

}

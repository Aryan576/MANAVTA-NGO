package com.manavtarestapi.bean;


import lombok.Data;

@Data
public class ResponseBean <T> {
     T Data;
    String msg;
    int status;


}

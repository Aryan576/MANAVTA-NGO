package com.manavtarestapi.dao;

import com.manavtarestapi.bean.SignupBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Signupdao {

    @Autowired
    JdbcTemplate stmt;

    public void signup(SignupBean signupBean) {
        stmt.update("insert into signup (firstname,lastname,gender,phonenumber,email,password,dob,address,roleid) values(?,?,?,?,?,?,?,?,?) ",
                signupBean.getFirstname(), signupBean.getLastname(), signupBean.getGender(), signupBean.getPhonenumber(), signupBean.getEmail(), signupBean.getPassword(),
                signupBean.getDob(), signupBean.getAddress(), signupBean.getRoleid());
    }

    public List<SignupBean> listUser() {
        List<SignupBean> user= stmt.query("select * from signup", BeanPropertyRowMapper.newInstance(SignupBean.class));
        return user;
    }
}

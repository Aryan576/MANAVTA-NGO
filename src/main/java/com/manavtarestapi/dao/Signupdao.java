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
        List<SignupBean> user = stmt.query("select * from signup", BeanPropertyRowMapper.newInstance(SignupBean.class));
        return user;
    }

    public SignupBean login(String email, String password) {

        SignupBean signupBean = null;
        try {
            signupBean = stmt.queryForObject("select * from signup where email=? and password=?", BeanPropertyRowMapper.newInstance(SignupBean.class), new Object[]{email, password});

        } catch (Exception e) {
            System.out.println("No such users");
        }

        return signupBean;
    }

    public SignupBean getUserByEmail(String email) {
        SignupBean signupBean = null;
        try {
            List<SignupBean> signup = stmt.query("select * from signup where email = ?",

                    BeanPropertyRowMapper.newInstance(SignupBean.class), new Object[]{email});

            if (signup.size() != 0) {
                signupBean = signup.get(0);
            }
        } catch (Exception e) {
            // TODO: handle exception

            System.out.println("No such user");
        }

        return signupBean;
    }

    public SignupBean getUserByID(int id) {
        SignupBean signupBean = null;
        try {
            List<SignupBean> sign = stmt.query("select * from signup where id=?", BeanPropertyRowMapper.newInstance(SignupBean.class));

            if (sign.size() != 0) {
                signupBean = sign.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

      return signupBean;
    }





    public void updatepassword(SignupBean signupBean) {
        stmt.update("update signup set password = ? where id = ?", signupBean.getPassword(), signupBean.getId());
    }
}

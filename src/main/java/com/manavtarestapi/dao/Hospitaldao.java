package com.manavtarestapi.dao;

import com.manavtarestapi.bean.AddHospitalBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Hospitaldao {


    @Autowired
    JdbcTemplate stmt;

    public void addHospital(AddHospitalBean addHospitalBean) {
        stmt.update("insert into hospital (hospitalname,location, hospitaladdress, numberbeds,pincode,hospitalphonenumber,lat,log) values(?,?,?,?,?,?,?,?)",
                addHospitalBean.getHospitalname(), addHospitalBean.getLocation(), addHospitalBean.getHospitaladdress(), addHospitalBean.getNumberbeds()
                , addHospitalBean.getPincode(), addHospitalBean.getHospitalphonenumber(), addHospitalBean.getLat(), addHospitalBean.getLog()

        );


    }

    public List<AddHospitalBean> listHospital() {

        List<AddHospitalBean> hospitalBean = stmt.query("select * from hospital", BeanPropertyRowMapper.newInstance(AddHospitalBean.class));
        return hospitalBean;
    }

    public AddHospitalBean updateHospital(AddHospitalBean addHospitalBean) {
        stmt.update("update  hospital set  hospitalname=?,location=?, hospitaladdress=?, numberbeds=?,pincode=?,hospitalphonenumber=?,lat=?,log=? where hospitalid=?",
                addHospitalBean.getHospitalname(),addHospitalBean.getLocation(), addHospitalBean.getHospitaladdress(), addHospitalBean.getNumberbeds(), addHospitalBean.getPincode(), addHospitalBean.getHospitalphonenumber(), addHospitalBean.getLat(), addHospitalBean.getLog(), addHospitalBean.getHospitalid());
            return addHospitalBean;
    }

    public AddHospitalBean deleteHospital(int hospitalid) {

        AddHospitalBean addHospitalBean = null;

        addHospitalBean = getHospitalByid(hospitalid);
        if (addHospitalBean != null) {
            stmt.update("delete from hospital where hospitalid=?", hospitalid);
        }

        return addHospitalBean;
    }

    private AddHospitalBean getHospitalByid(int hospitalid) {

        AddHospitalBean addHospitalBean = null;
        try {
            addHospitalBean = stmt.queryForObject("select * from hospital where hospitalid=?", BeanPropertyRowMapper.newInstance(AddHospitalBean.class), new Object[]{hospitalid});

        } catch (Exception e) {
            System.out.println("Role not  Found" + e.getMessage());
        }

        return addHospitalBean;


    }
}

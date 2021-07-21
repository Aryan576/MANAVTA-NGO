package com.manavtarestapi.dao;


import com.manavtarestapi.bean.DonatePlasmaBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonatePlasmadao {

    @Autowired
    JdbcTemplate stmt;

    public void addPlasma(DonatePlasmaBean donatePlasmaBean) {

        stmt.update("insert into plasma (name, age, gender, bloodgroup, weight,DateofcovidPositive,DateofcovidNegative,city,state,phonenumber) values(?,?,?,?,?,?,?,?,?,?)",
                donatePlasmaBean.getName(), donatePlasmaBean.getAge(), donatePlasmaBean.getGender(), donatePlasmaBean.getBloodgroup(), donatePlasmaBean.getWeight(), donatePlasmaBean.getDateofcovidPositive(), donatePlasmaBean.getDateofcovidNegative(),
                donatePlasmaBean.getCity(), donatePlasmaBean.getState(), donatePlasmaBean.getPhonenumber()

        );
    }

    public List<DonatePlasmaBean> getPlasmaDetails() {
        List<DonatePlasmaBean> donatePlasma = stmt.query("select * from plasma ", BeanPropertyRowMapper.newInstance(DonatePlasmaBean.class));

        return donatePlasma;
    }

    public DonatePlasmaBean deleteplasma(int plasmaid) {

        DonatePlasmaBean donatePlasma = null;

        donatePlasma = getPlasmaByID(plasmaid);

        if (donatePlasma != null) {
            stmt.update("delete from plasma where plasmaid=?", plasmaid);
        }

        return donatePlasma;
    }

    private DonatePlasmaBean getPlasmaByID(int plasmaid) {

        DonatePlasmaBean donatePlasma = null;

        try {
            donatePlasma = stmt.queryForObject("select * from plasma where plasmaid=?", BeanPropertyRowMapper.newInstance(DonatePlasmaBean.class), new Object[]{plasmaid});

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return donatePlasma;
    }

    public DonatePlasmaBean updatePlasma(DonatePlasmaBean donatePlasma) {
        stmt.update("update plasma set name=?, age=?, gender=?, bloodgroup=?, weight=?,DateofcovidPositive=?,DateofcovidNegative=?,city=?,state=?,phonenumber=? where plasmaid=?",
                donatePlasma.getName(),donatePlasma.getAge(),donatePlasma.getGender(),donatePlasma.getBloodgroup(),donatePlasma.getWeight(),
                donatePlasma.getDateofcovidPositive(),donatePlasma.getDateofcovidNegative(),donatePlasma.getCity(), donatePlasma.getState(),donatePlasma.getPhonenumber(),donatePlasma.getPlasmaid()
                );

                return donatePlasma;

    }
}

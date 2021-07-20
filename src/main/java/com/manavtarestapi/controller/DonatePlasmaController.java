package com.manavtarestapi.controller;


import com.manavtarestapi.bean.DonatePlasmaBean;
import com.manavtarestapi.bean.ResponseBean;
import com.manavtarestapi.dao.DonatePlasmadao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class DonatePlasmaController {

    @Autowired
    DonatePlasmadao donatePlasmadao;

    @PostMapping("addPlasma")
    public ResponseBean<DonatePlasmaBean> addplasma(@RequestBody DonatePlasmaBean donatePlasmaBean)
    {
        ResponseBean<DonatePlasmaBean> responseBean =  new ResponseBean<>();

        donatePlasmadao.addPlasma(donatePlasmaBean);
        responseBean.setData(donatePlasmaBean);
        responseBean.setMsg("Plasma Detail Added");
        responseBean.setStatus(200);

        return responseBean;
    }



    
}

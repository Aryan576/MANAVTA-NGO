package com.manavtarestapi.controller;


import com.manavtarestapi.bean.DonatePlasmaBean;
import com.manavtarestapi.bean.ResponseBean;
import com.manavtarestapi.dao.DonatePlasmadao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DonatePlasmaController {

    @Autowired
    DonatePlasmadao donatePlasmadao;

    @PostMapping("addPlasma")
    public ResponseBean<DonatePlasmaBean> addplasma(@RequestBody DonatePlasmaBean donatePlasmaBean) {
        ResponseBean<DonatePlasmaBean> responseBean = new ResponseBean<>();

        donatePlasmadao.addPlasma(donatePlasmaBean);
        responseBean.setData(donatePlasmaBean);
        responseBean.setMsg("Plasma Detail Added");
        responseBean.setStatus(200);

        return responseBean;
    }

    @GetMapping("Listplasma")
    public ResponseBean<List<DonatePlasmaBean>> ListPlasma() {
        ResponseBean<List<DonatePlasmaBean>> responese = new ResponseBean<>();

        List<DonatePlasmaBean> donatePlasma = donatePlasmadao.getPlasmaDetails();

        responese.setData(donatePlasma);
        responese.setMsg("Plasma Details ");
        responese.setStatus(200);

        return responese;
    }

    @DeleteMapping("deleteplasma/{plasmaid}")
    public ResponseBean<DonatePlasmaBean> deleteplasma(@PathVariable("plasmaid") int plasmaid) {
        ResponseBean<DonatePlasmaBean> response = new ResponseBean<>();
        DonatePlasmaBean donatePlasma = donatePlasmadao.deleteplasma(plasmaid);
        response.setData(donatePlasma);
        if (donatePlasma != null) {

            response.setMsg("Plasma Found");
            response.setStatus(200);
        } else {
            response.setMsg("Plasma Detial Not Found ");
            response.setStatus(201);
        }

        return response;
    }

    @PutMapping("UpdatePlasma")
    public ResponseBean<DonatePlasmaBean> updateplasma(@RequestBody DonatePlasmaBean donatePlasma)
    {
        ResponseBean<DonatePlasmaBean> response= new ResponseBean<>();
      donatePlasmadao.updatePlasma(donatePlasma);

        response.setData(donatePlasma);
        response.setMsg("Plasma Details Updated");
        response.setStatus(200);
        return response;
    }


}

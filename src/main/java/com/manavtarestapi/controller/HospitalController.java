package com.manavtarestapi.controller;

import com.manavtarestapi.bean.AddHospitalBean;
import com.manavtarestapi.bean.ResponseBean;
import com.manavtarestapi.dao.Hospitaldao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class HospitalController {

    @Autowired
    Hospitaldao hospitaldao;

    @PostMapping("addHospital")
    public ResponseBean<AddHospitalBean> addHospital(@RequestBody AddHospitalBean addHospitalBean) {

        ResponseBean<AddHospitalBean> response = new ResponseBean<>();
        hospitaldao.addHospital(addHospitalBean);
        response.setData(addHospitalBean);
        response.setMsg("Hospital added");
        response.setStatus(200);

        return response;

    }

    @GetMapping("ListHospital")
    public ResponseBean<List<AddHospitalBean>> listHospital() {
        ResponseBean<List<AddHospitalBean>> response = new ResponseBean<>();
        List<AddHospitalBean> addHospitalBeans = hospitaldao.listHospital();
        response.setData(addHospitalBeans);
        response.setMsg("List of Hospital");
        response.setStatus(200);

        return response;
    }

    @PutMapping("updateHospital")
    public ResponseBean<AddHospitalBean> updateHospital(@RequestBody AddHospitalBean addHospitalBean) {
        ResponseBean<AddHospitalBean> response = new ResponseBean<>();
        hospitaldao.updateHospital(addHospitalBean);
        response.setData(addHospitalBean);
        response.setMsg("Hospital Updated");
        response.setStatus(200);
        return response;
    }


    @DeleteMapping("deleteHospital")
    public ResponseBean<AddHospitalBean> deleteHospital(@PathVariable("hospitalid") int hospitalid) {
        ResponseBean<AddHospitalBean> response=new ResponseBean<>();

        AddHospitalBean addHospitalBean=hospitaldao.deleteHospital(hospitalid);

        response.setData(addHospitalBean);
        if(addHospitalBean!=null)

        {
            response.setMsg("Hospital Added");
        }
          else
        {
            response.setMsg("No Hospital Found!!");
        }
            


        response.setStatus(200);


        return response;

    }

}

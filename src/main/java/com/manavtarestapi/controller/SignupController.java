package com.manavtarestapi.controller;


import com.manavtarestapi.bean.LoginBean;
import com.manavtarestapi.bean.ResponseBean;
import com.manavtarestapi.bean.SignupBean;
import com.manavtarestapi.dao.Signupdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SignupController {
    @Autowired
    Signupdao signupdao;

    @PostMapping("signup")
    public ResponseBean<SignupBean> signup(@RequestBody SignupBean signupBean) {
        ResponseBean resposne = new ResponseBean();

        signupdao.signup(signupBean);
        resposne.setData(signupBean);
        resposne.setMsg("User Signup Success");
       /* resposne.setStatus(200);*/

        return resposne;

    }


    @PostMapping("login")
    public ResponseBean<SignupBean> userLogin(@RequestBody LoginBean loginBean)
    {
        SignupBean signupBean=null;
        ResponseBean<SignupBean> responseBean =  new ResponseBean<>();
        signupBean=signupdao.login(loginBean.getEmail(),loginBean.getPassword());

       if(signupBean !=null)
       {
           responseBean.setData(signupBean);
           responseBean.setStatus(200);
           responseBean.setMsg("User login");
       }
       else {
           responseBean.setStatus(201);
           responseBean.setMsg("User Not Found");

       }

        return responseBean;

    }
    @GetMapping("Listuser")
    public  ResponseBean<List<SignupBean>> listuser()
    {
        ResponseBean<List<SignupBean>> resposne= new ResponseBean<>();
        List<SignupBean> signupbean=signupdao.listUser();

        resposne.setData(signupbean);
        resposne.setMsg("User List");
        resposne.setStatus(200);

        return resposne;
    }

}

package com.manavtarestapi.controller;


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
        signupBean.setRoleid(2);
        signupdao.signup(signupBean);
        resposne.setData(signupBean);
        resposne.setMsg("User Signup Success");
        resposne.setStatus(200);

        return resposne;

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

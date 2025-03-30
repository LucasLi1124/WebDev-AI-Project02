package com.llf.controller;

import com.llf.pojo.Emp;
import com.llf.pojo.LoginInfo;
import com.llf.pojo.Result;
import com.llf.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;


    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("登录信息：{}", emp);
        LoginInfo loginInfo1 =  empService.login(emp);

        if ( loginInfo1 != null){
            return Result.success(loginInfo1);
        }
        return Result.error("用户名或密码错误");
    }
}

package com.example.bookmanager.controller;

import com.example.bookmanager.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    private UserMapper userMapper;
    @PostMapping("/register")
    public String register(@RequestParam("userName")String userName,@RequestParam("passWord")String passWord,
                         @RequestParam("nickName")String nickName,@RequestParam("phoneNumber")String phoneNumber){
        //注册事件
        //MyBatis:< delete >、< update >、< insert >等语句的操作成功返回1，失败返回0
        int sqlResult=userMapper.register(userName,passWord,nickName,phoneNumber);
        if (sqlResult==1){
            return "Register Success";
        }else{
            return "Register Failed";
        }
    }
}

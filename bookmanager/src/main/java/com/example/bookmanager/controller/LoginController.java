package com.example.bookmanager.controller;

import com.example.bookmanager.model.vo.UserVO;
import com.example.bookmanager.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    UserService userService ;
    @PostMapping("/login")
    private Object logIn(@Param("userName")String userName, @Param("passWord")String passWord,
                         HttpServletRequest request, HttpServletResponse response){
        UserVO userVO=userService.login(userName,passWord);
        if(userVO==null){
            return "loginFailed";
        }else {
            //设置cookie
            Cookie cookieId=new Cookie("userId",userVO.getId());
            Cookie cookieName=new Cookie("userName",userVO.getUsername());
            //设置cookie浏览器关闭后失效
            cookieId.setMaxAge(-1);
            cookieName.setMaxAge(-1);
            //将cookie添加到response中
            response.addCookie(cookieId);
            response.addCookie(cookieName);
            //通过request方式传值前台只能获取一次
            request.setAttribute("userId",userVO.getId());
            request.setAttribute("userName",userVO.getUsername());
            return "loginSuccess";
        }
    }
}

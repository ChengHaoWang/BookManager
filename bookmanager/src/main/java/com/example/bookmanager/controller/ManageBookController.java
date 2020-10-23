package com.example.bookmanager.controller;

import com.example.bookmanager.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ManageBookController {
    @Autowired
    BookService bookService ;
    @PostMapping("/addbook")
    public String addbook(@CookieValue(name="userId",required=false)String userId,
                          @Param("bookname")String bookName,@Param("description")String description){
        //通过cookie判断是否已经登录
        if(userId==null){
            return "请先登录";
        }
        int resultCode=bookService.addBook(bookName,description,userId);
        if (resultCode==1){
            return "add success";
        }else{
            return "add failed";
        }
    }
}

package com.example.bookmanager.controller;

import com.example.bookmanager.model.vo.BookVO;
import com.example.bookmanager.service.BookService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ManageBookController {
    @Autowired
    BookService bookService ;
    //添加书籍
    @PostMapping("/addbook")
    public String addbook(@CookieValue(name="userId",required=false)String userId,
                          @Param("bookName")String bookName,@Param("description")String description){
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
    //删除书籍
    @PostMapping("/deletebook")
    public String deleteBook(@CookieValue(name="userId",required=false)String userId,
                             @Param("bookName")String bookName){
        //通过cookie判断是否已经登录
        if(userId==null){
            return "请先登录";
        }
        int resultCode=bookService.deleteBook(bookName,userId);
        if (resultCode==1){
            return "delete success";
        }else {
            return "delete failed";
        }
    }
    //修改书籍
    @PostMapping("updatebook")
    public String updateBook(@CookieValue(name="userId",required=false)String userId,
                           @Param("bookName")String bookName,@Param("description")String description,
                             @Param("bookId")String bookId){
        //通过cookie判断是否已经登录
        if(userId==null){
            return "请先登录";
        }
        int resultCode=bookService.updateBook(bookId,bookName,description);
        if (resultCode==1){
            return "update success";
        }else {
            return "update failed";
        }
    }
    //查询所有书籍
    @PostMapping("querybook")
    public List<BookVO> queryBook(@CookieValue(name="userId",required=false)String userId){
        List<BookVO> bookList =bookService.queryBook(userId);
        return bookList;
    }
    //分页查询书籍
    /**
     *
     * @param userId
     * @param pageCount 当前页数
     * @param pageSize 每页显示的总记录数
     * @return
     */
    @PostMapping("querybookbypage")
    public PageInfo<BookVO> queryBookByPage(@CookieValue(name="userId",required = false)String userId,@Param("pageCount") int pageCount,
                                            @Param("pageSize")int pageSize){
        PageInfo<BookVO> pageList =bookService.queryBookByPage(userId,pageCount,pageSize);
        return pageList;
    }
}

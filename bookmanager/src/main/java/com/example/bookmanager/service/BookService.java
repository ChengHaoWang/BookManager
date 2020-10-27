package com.example.bookmanager.service;

import com.example.bookmanager.mapper.BookMapper;
import com.example.bookmanager.model.vo.BookVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper ;
    public int addBook(String bookName,String description,String userId){
        int resultCode=bookMapper.addBook(bookName,description,userId);
        return resultCode;
    }
    public int deleteBook(String bookName,String userId){
        int resultCode=bookMapper.deleteBook(bookName,userId);
        return resultCode;
    }
    public int updateBook(String id, String bookName,String description){
        int resultCode=bookMapper.updateBook(id,bookName,description);
        return resultCode;
    }
    public List<BookVO> queryBook(String userId){
        List<BookVO> bookList =bookMapper.queryBook(userId);
        return bookList;
    }
    public PageInfo<BookVO> queryBookByPage(String userId,int pageCount,int pageSize){
        PageHelper.startPage(pageCount,pageSize);
        List<BookVO> bookList =bookMapper.queryBookByPage(userId,pageCount,pageSize);
        return new PageInfo(bookList);
    }
}

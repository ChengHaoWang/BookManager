package com.example.bookmanager.service;

import com.example.bookmanager.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper ;
    public int addBook(String bookName,String description,String userId){
        int resultCode=bookMapper.addBook(bookName,description,userId);
        return resultCode;
    }
}

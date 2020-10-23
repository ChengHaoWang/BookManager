package com.example.bookmanager.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface  BookMapper {
    int addBook(@Param("bookName")String bookName,@Param("description")String description,
                @Param("userId")String userId);
}

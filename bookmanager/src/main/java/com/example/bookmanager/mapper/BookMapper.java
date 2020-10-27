package com.example.bookmanager.mapper;

import com.example.bookmanager.model.vo.BookVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface  BookMapper {
    //增
    int addBook(@Param("bookName")String bookName,@Param("description")String description,
                @Param("userId")String userId);
    //删
    int deleteBook(@Param("bookName")String bookName,@Param("userId")String userId);
    //改
    int updateBook(@Param("bookId")String bookId,@Param("bookName")String bookName,@Param("description")String description);
    //查
    List<BookVO> queryBook(@Param("userId")String userId);
    //分页查询
    List<BookVO> queryBookByPage(@Param("userId")String userId,int pageCount,int pageSize);
}

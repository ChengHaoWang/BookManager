package com.example.bookmanager.mapper;

import com.example.bookmanager.model.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    //当该函数含有多个参数时，如果不加@Param注解，XML中的Mapper会找不到变量
    int register(@Param("username") String usrename, @Param("password")String password,
                 @Param("nickname")String nickname, @Param("phonenumber")String phonenumber);
    UserVO login(@Param("username")String username,@Param("password")String password);
}

package com.example.bookmanager.service;

import com.example.bookmanager.mapper.UserMapper;
import com.example.bookmanager.model.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public UserVO login(String username, String password){
        UserVO userVO=userMapper.login(username,password);
        return userVO;
    }
}

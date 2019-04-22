package com.example.service;


import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(int id){
        return userMapper.getUserById(id);
    }

    public ArrayList<User> getUser(){
        return userMapper.getUser();
    }

    public void setUser(User user){
        userMapper.setUser(user);
    }

    public void deleteUserById(int id){
        userMapper.deleteUserById(id);
    }
    public void updateUser(User user){
        userMapper.updateUser(user);
    }
    public ArrayList<User> getUserByPage(int currIndex,int pageSize){

        return userMapper.getUserByPage(currIndex,pageSize);
    }
    public ArrayList<User> getUserByAny(User user,int id){
        return userMapper.getUserByAny(user,id);
    }
    public void setUserByAny(User user,int id){
        userMapper.setUserByAny(user,id);
    }
}

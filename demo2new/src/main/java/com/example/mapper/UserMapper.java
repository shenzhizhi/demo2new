package com.example.mapper;


import com.example.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserMapper {

    User getUserById(int id);

    ArrayList<User> getUser();

    void setUser(User user);

    void deleteUserById(int id);

    void updateUser(User user);

    //    ArrayList<User> getUserByPage(@Param("currIndex")int currIndex, @Param("pageSize")int pageSize);
//    如果没有加@Param，xml中就需要使用#{param1}，#{param2}
    ArrayList<User> getUserByPage(int currIndex, int pageSize);

    ArrayList<User> getUserByAny(@Param("user") User user, int id);

    void setUserByAny(@Param("user") User user, int id);

}

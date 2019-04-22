package com.example.pojo;

public class User {
    private Integer id;
    private String UserName;
    private String PassWord;
    private String RealName;

    public User(String userName, String passWord, String realName) {
        UserName = userName;
        PassWord = passWord;
        RealName = realName;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", RealName='" + RealName + '\'' +
                '}';
    }
}

package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.pojo.Code;
import com.example.pojo.LoginUser;
import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static String rightName="shenzhi";
    private static String rightPassword="123";

    @Autowired
    UserService userService=null;


    @RequestMapping(value = "/demo")
    public String toDemo(){
        System.out.println("进入demo");
        return "demo";
    }

    @RequestMapping(value = "/getName")
    public void getName(@RequestParam("userId")int userId,@RequestParam("username")String name, HttpServletResponse response){
        System.out.println("userid:"+userId);
        System.out.println("username:"+name);

//        CookieUtils.getCookie(response,username);

        response.setHeader("Access-Control-Allow-Origin", "*");
//        设置内容格式加编码
        response.setContentType("application/json;charset=UTF-8");


        ArrayList<User> arrayList=userService.getUser();

        String ss=JSON.toJSONString(arrayList);
        System.out.println(ss);
        PrintWriter pw= null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (pw != null) {
            pw.write(ss);
            pw.flush();
            pw.close();
        }

    }

    @RequestMapping("/setUser")
    public String setUser(
            @RequestParam("userName")String userName,
            @RequestParam("passWord")String passWord,
            @RequestParam("realName")String realName
    ){
        userService.setUser(new User(userName,passWord,realName));
        return "demo";
    }

    @RequestMapping("/deleteUserById")
    public String deleteUserById(@RequestParam("userId")int id){
        userService.deleteUserById(id);
        return "demo";
    }

    @RequestMapping("/updateUser")
    public void updateUser(HttpServletResponse resp,HttpServletRequest req,@RequestBody User user){
        System.out.println(user.toString());
        userService.updateUser(user);
        String s2="{\"code\":\"1\"}";
        try {
            PrintWriter pw =resp.getWriter();
            pw.write(s2);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        System.out.println("进入toLogin");
        return "login";
    }

    @RequestMapping(value = "/login" )
    public  String login(HttpServletRequest req,
                       HttpServletResponse resp,
                       @RequestBody LoginUser loginUser,
                       HttpSession httpSession,
                       Map<String,Object> map

    ){
        Cookie[] cookies=req.getCookies();
        for(Cookie c :cookies){
            if(c.getName().equals("userCookie")){
                if(c.getValue().equals("nima")){
                    //已登录
                }
            }
        }
        /* todo */
        if(req.getSession(true)==null)
        httpSession=req.getSession();
        Cookie cookie=new Cookie("sessionid",httpSession.getId());


        System.out.println("进入login");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("收到名字："+loginUser.getName()+" "+"密码："+loginUser.getPassword() );
        if(loginUser.getName().equals("shenzhi")&&loginUser.getPassword().equals("123123")){
            httpSession.setAttribute("loginUser",loginUser.getName());
            return "demo";
        }else{
            map.put("msg","用户名密码错误");
            return "login";
        }





    }

}

package com.example.Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CookieUtils {
    public static String getCookie(HttpServletRequest req,String cookieName){
        HttpSession session=req.getSession();
        if(!session.isNew()){
            
        }
        Cookie[] cookies=req.getCookies();
        if(cookies!=null){
            for(Cookie c : cookies){
                if(c.getName().equals(cookieName)){
                    return c.getValue();
                }
            }
        }
        return null;
    }
    public static void writeCookie(HttpServletResponse resp,String name,String password){
        Cookie cookie=new Cookie(name,password);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);

    }
}

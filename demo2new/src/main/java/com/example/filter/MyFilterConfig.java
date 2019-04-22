package com.example.filter;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootApplication
public class MyFilterConfig implements HandlerInterceptor {

    private static Logger logger = Logger.getLogger(MyFilterConfig.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截前");

        logger.info("asdasdasd");
//        ajax在发送json格式的数据是，会先发送一个options请求，在这时，单纯的在业务接口response添加Access-Control-Allow-Origin 由于还没有走到所以不会起作用。

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        /*System.out.println(request.getRequestURL());
        System.out.println(request.getMethod());
        HttpSession session=request.getSession();
        System.out.println("session的id是："+session.getId());
        System.out.println("req的getContextPath是："+request.getContextPath());
        Object info=session.getAttribute("userInfo");
        if(info==null){
//            还没有登录
            response.sendRedirect(request.getContextPath()+"/user/login");
            return false;
        }else{
//            已经登录
        }*/
        return true;


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截后");
        System.out.println(response.getStatus());
        System.out.println("========================================");
    }
}

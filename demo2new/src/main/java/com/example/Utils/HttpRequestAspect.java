package com.example.Utils;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/*@Aspect
@Component*/
public class HttpRequestAspect {
    private static final Logger logger=Logger.getLogger(HttpRequestAspect.class);

    @Pointcut("execution(* com.example.controller.UserController.*(..))&&(@annotation(org.springframework.web.bind.annotation.RequestMapping))")
    public void print(){}

    @Before("print()")
    public void ceshi(JoinPoint jp){
        logger.info("进入前置方法");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response=requestAttributes.getResponse();
        HttpSession session=request.getSession();

        if(!(session.getAttribute("loginUser")==null)){
//            已经登录
            System.out.println("已经登录");

        }else{
            System.out.println("没有登录");
            try {
                response.sendRedirect("http://localhost:8080/user/toLogin");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("我是before中的请求url"+request.getRequestURL());

    }
}

package com.example.demo2new;

import com.example.pojo.User;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2newApplicationTests {

    @Autowired
    private UserService userService;

	@Test
	public void contextLoads() {
	    ArrayList<User> arrayList=userService.getUserByPage(0,3);
	    for(User uu :arrayList){
            System.out.println(uu.toString());
        }

	   /*User user=new User();
	   user.setUserName("神芝芝");
	   userService.setUserByAny(user,1);
	   System.out.println(userService.getUserById(1).toString());*/

	  /*User user=new User();
	  user.setUserName("神芝");
	  ArrayList<User> arrayList=userService.getUserByAny(user,1);
	  for(User u:arrayList){
          System.out.println(u);
      }*/
	}

}

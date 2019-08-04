package com.yuanziren.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void addUser() throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.addUser();
    }

    @Test
    public void addUser2() throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.addAccount();
    }
}
package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        // Bean 가져오기
        User generalUser = context.getBean("generalUser", User.class);
        User adminUser = context.getBean("adminUser", User.class);

        System.out.println("******1. GeneralUser");
        try {
            generalUser.useApp();
        } catch (ApplicationException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("******2. AdminUser");
        try {
            adminUser.useApp();
        } catch (ApplicationException e) {}
    }
}


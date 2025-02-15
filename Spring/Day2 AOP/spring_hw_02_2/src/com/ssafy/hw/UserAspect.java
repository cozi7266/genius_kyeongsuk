package com.ssafy.hw;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

    @Before("execution(* com.ssafy.hw.User.useApp(..))")
    public void before() {
        System.out.println("애플리케이션을 시작합니다.");
    }

    @AfterReturning("execution(* com.ssafy.hw.User.useApp(..))")
    public void afterReturn() {
        System.out.println("애플리케이션 사용을 끝냅니다.");
    }

    @AfterThrowing(pointcut = "execution(* com.ssafy.hw.User.useApp(..))", throwing = "ex")
    public void afterThrow(Throwable ex) {
        System.out.println("애플리케이션에 문제가 생겨 점검합니다.");
        System.out.println(ex.getClass().getName()); // 예외 클래스의 전체 경로를 출력
    }

    @After("execution(* com.ssafy.hw.User.useApp(..))")
    public void after() {
        System.out.println("애플리케이션을 상태와 관련없이 종료합니다.");
    }
}

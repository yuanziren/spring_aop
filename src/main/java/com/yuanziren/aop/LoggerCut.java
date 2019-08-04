package com.yuanziren.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LoggerCut {

    // 拦截规则
    @Pointcut("execution (* com.yuanziren.service..*.*(..))")
    public void cut(){}

    @Before("cut()")
    public void before(){
        System.out.println("before...");
    }

    @After("cut()")
    public void after(){
        System.out.println("after...");
    }

    @AfterThrowing(pointcut = "cut()", throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("afterThrowing...");
    }

    @Around("cut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前置...");
        System.out.println(pjp.getTarget()+"--"+pjp.getSignature());
        Object result=pjp.proceed();
        System.out.println("环绕后置...");
        return result;
    }

    @AfterReturning("cut()")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }
}

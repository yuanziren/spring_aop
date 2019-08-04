package com.yuanziren.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class LogCut2 {

    public void cut(){}

    public void before(){
        System.out.println("before...22");
    }

    public void after(){
        System.out.println("after...22");
    }

    public void afterThrowing(Exception e){
        System.out.println("afterThrowing...22");
    }

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前置...22");
        System.out.println(pjp.getTarget()+"--"+pjp.getSignature());
        Object result=pjp.proceed();
        System.out.println("环绕后置...22");
        return result;
    }
    public void afterReturning(){
        System.out.println("afterReturning...22");
    }
}

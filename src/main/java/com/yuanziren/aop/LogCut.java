package com.yuanziren.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogCut {

    // 拦截规则
    @Pointcut("execution (* com.yuanziren.service.UserService.addUser())")
    public void cut(){}

    @Before("cut()")
    public void before(){
        System.out.println("Service 被拦截---start");
        System.out.println("[ session 开启事务 ]");
    }

    @After("cut()")
    public void after(){
        System.out.println("Service 被拦截---end");
        System.out.println("[ session 提交事务 ]");
    }

    @AfterThrowing(pointcut = "cut()", throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("程序发生异常: "+e.getMessage());
        System.out.println("[ session 回滚事务 ]");
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
        System.out.println("程序正常返回");
    }
}

package com.yuanziren.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKHandler implements InvocationHandler {

    private Object target;//目标对象

    public JDKHandler(Object target) {
        this.target = target;
    }

    // 动态创建代理对象
    public Object getProxy(){
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),// 类加载器
                target.getClass().getInterfaces(),// 目标实现的接口
                this // 当前类
        );
    }

    public void before(){
        System.out.println("布置婚礼现场...");
    }

    public void after(){
        System.out.println("送亲朋好友...");
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }
}

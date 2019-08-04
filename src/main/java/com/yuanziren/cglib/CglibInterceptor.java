package com.yuanziren.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibInterceptor  implements MethodInterceptor{

    private Object target;

    public CglibInterceptor(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    public void before(){
        System.out.println("布置婚礼现场...");
    }

    public void after(){
        System.out.println("送亲朋好友...");
    }

    @Override
    public Object intercept(Object o,
                            Method method,
                            Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invoke(target, args);
        after();
        return result;
    }
}

package com.yuanziren.jdk;

import com.yuanziren.service.You;
import org.junit.Test;


public class JDKHandlerTest {

    @Test
    public void invoke() throws Throwable {
        You you = new You();// 委托类
        JDKHandler jdkHandler = new JDKHandler(you);// 创建动态代理工厂类
        Object proxy = jdkHandler.getProxy();// 创建代理对象

        jdkHandler.invoke(proxy, You.class.getMethod("toMarry"),null);
    }
}
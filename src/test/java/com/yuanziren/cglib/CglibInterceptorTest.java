package com.yuanziren.cglib;

import com.yuanziren.service.You;
import org.junit.Test;

import static org.junit.Assert.*;

public class CglibInterceptorTest {

    @Test
    public void getProxy() throws Exception {

        You you = (You) new CglibInterceptor(new You()).getProxy();
        you.toMarry();

    }
}
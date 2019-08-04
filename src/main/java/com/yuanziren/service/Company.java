package com.yuanziren.service;

public class Company implements Marry{

    private You target;// 目标对象

    public Company(You target) {
        this.target = target;
    }

    public void before(){
        System.out.println("布置婚礼现场...");
    }

    public void after(){
        System.out.println("送亲朋好友...");
    }

    @Override
    public void toMarry() {
        before();
        target.toMarry();
        after();
    }
}
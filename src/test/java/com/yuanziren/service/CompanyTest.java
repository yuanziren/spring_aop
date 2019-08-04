package com.yuanziren.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyTest {

    @Test
    public void toMarry() {
        You you = new You();
        Company company = new Company(you);
        company.toMarry();
    }
}
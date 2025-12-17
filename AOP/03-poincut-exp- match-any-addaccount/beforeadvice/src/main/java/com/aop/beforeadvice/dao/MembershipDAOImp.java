package com.aop.beforeadvice.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImp implements AccountDAO {
    @Override
    public void addAccount() {

        System.out.println(getClass()+": doing my db work: adding an account");
    }
}

package com.aop.beforeadvice.dao;

import com.aop.beforeadvice.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImp implements AccountDAO {
    @Override
    public void addAccount(Account theAccount) {

        System.out.println(getClass()+": doing my db work: adding an account");
    }
}

package com.aop.beforeadvice.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImp implements MembershipDAO {
    @Override
    public boolean addMemberDAO() {

        System.out.println(getClass()+": doing my db work: adding a Membership account");
        return true;
    }
}

package com.diannotations.commentscanning.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("cricket constructor :"+getClass().getSimpleName());
    }
 // init method
    @PostConstruct
    public void initMethod()
    {
        System.out.println("init method : "+getClass().getSimpleName());
    }


    // destroy method

    @PreDestroy
    public void destroyMethod()
    {
        System.out.println("destroy method : "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return " cricket workout stated yahooo!!!!";
    }
}

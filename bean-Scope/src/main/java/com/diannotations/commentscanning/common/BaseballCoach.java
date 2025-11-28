package com.diannotations.commentscanning.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("baseball constructor :"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "baseball workout start";
    }
}

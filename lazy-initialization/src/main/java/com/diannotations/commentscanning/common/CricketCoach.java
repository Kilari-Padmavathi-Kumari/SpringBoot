package com.diannotations.commentscanning.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("cricket constructor :"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return " cricket workout stated yahooo!!!!";
    }
}

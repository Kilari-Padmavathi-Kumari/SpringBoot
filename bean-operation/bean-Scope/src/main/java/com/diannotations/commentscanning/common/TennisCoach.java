package com.diannotations.commentscanning.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("tennis constructor :"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "tennis workout start";
    }
}

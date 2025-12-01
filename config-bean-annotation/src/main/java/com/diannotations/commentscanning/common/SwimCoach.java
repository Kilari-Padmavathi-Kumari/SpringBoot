package com.diannotations.commentscanning.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("swim constructor :"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "swim method run";
    }
}

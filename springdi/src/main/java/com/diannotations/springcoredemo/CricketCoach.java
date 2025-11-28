package com.diannotations.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coachinterface{

    @Override
    public String getDailyWork() {
        return "dailywork out started yahooooo!!!!";
    }
}

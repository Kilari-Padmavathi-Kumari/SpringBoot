package com.diannotations.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coachinterface myCoach;

    @Autowired
    public DemoController(Coachinterface myCoach) {
        this.myCoach = myCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkOut()
    {
        return myCoach.getDailyWork();
    }
}

package com.diannotations.commentscanning.rest;

import com.diannotations.commentscanning.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired

    public DemoController( Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping
    public String getDailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }


}

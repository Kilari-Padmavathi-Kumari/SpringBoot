package com.diannotations.commentscanning.rest;

import com.diannotations.commentscanning.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    private Coach anotherCoach;

    @Autowired

    public DemoController(@Qualifier("baseballCoach") Coach myCoach,@Qualifier("baseballCoach") Coach anotherCoach) {

            System.out.println("Demo Controller :"+getClass().getSimpleName());

        this.myCoach = myCoach;
        this.anotherCoach=anotherCoach;
    }

    @GetMapping
    public String getDailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String check()
    {
        return "comapring beans : myCoach=anotherCoach ,  "+(myCoach==anotherCoach);
    }


}

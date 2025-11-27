package com.Springboot.Twogetmapping.testing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getmapping {

    @GetMapping("/")
    public String sayHello()
    {
        return "helloworld padma";
    }
    // expose a new endpoint for"workout"
    @GetMapping("/workout")
    public String getDailyWorkout()
    {
        return "run a hard";
    }
    // expose a new endpoint for"fortune"
    @GetMapping("/fortune")
    public String getDailyFortune()
    {
        return "Today is your lucky day.....  yahooooooooo";
    }


}

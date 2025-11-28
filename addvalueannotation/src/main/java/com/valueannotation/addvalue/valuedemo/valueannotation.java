package com.valueannotation.addvalue.valuedemo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class valueannotation {

    @Value("${coach.name}")
    private String coachname;

    @Value("${team.name}")
    private String teamname;

    @GetMapping("/valuesinfo")
    public String call()
    {
        return "coach : "+coachname + ", Team name : " + teamname;
    }
}

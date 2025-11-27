package com.example.usingSettergetter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope
public class NewClass {


    private int id;
    private int name;
    private int tech;

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public int getTech() {
        return tech;
    }
    public void show()
    {
        System.out.println("in show");
    }
}

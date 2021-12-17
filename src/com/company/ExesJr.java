package com.company;

public class ExesJr extends Exes{
    String name;//просто переопределяес
    public ExesJr(String name, String nameSecond, int age, int height) {
        super(nameSecond, age, height);
        this.name = name;
    }
}

package com.company;

public class Cat extends Animal {
    String name;
    void makeSound() {
        System.out.println("meow");
    }
    public Cat() {};
    public Cat(String color, String name, int age, int height) {
        super(color, age, height);
        this.name = name;
    }

}

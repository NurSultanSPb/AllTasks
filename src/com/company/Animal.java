package com.company;

class Animal {
    String color;
    int age;
    int height;
    public void eat() {
        System.out.println("I am eating...");
    }
    public Animal() {
        System.out.println("Вызван констрктор родительского класса Animal");
    };
    public Animal(String color,
            int age,
            int height) {
        this.color = color;
        this.age = age;
        this.height = height;
    }
    protected class Army {

    }
    private class Armye {

    }

}
class Army {

}
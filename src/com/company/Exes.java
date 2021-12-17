package com.company;

public class Exes {
     String name;
     int age;
     int height;
     String nationality;

    public Exes(int height, String nationality) {
        this.height = height;
        this.nationality = nationality;
    }

    public Exes(String name, int age, int height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }
    public Exes(String name, int age, int height, String nationality) {
        this(height, nationality);
        this.age = age;
        this.name = name;
    }

}

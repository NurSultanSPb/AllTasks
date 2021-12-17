package JavaRushTest;
import java.util.Scanner;
import java.util.Arrays;
public class ClassesAndObjects {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("Roma");
        person1.age = 15;
        person1.speak();
        person1.sayHello();
        System.out.println((person1.calculate()));
    }
}
class Person {
    String name;
    int age;
    void setName(String username){
        name = username;
    }
    void speak(){
        System.out.println("My name is " + name + " I am " + age + " years");
    }
    void sayHello(){
        System.out.println("Hello!");
    }
    int calculate(){
        int years = 65 - age;
        return years;
    }

}

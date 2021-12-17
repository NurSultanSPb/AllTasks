package FuncInter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
interface AbleToEat {
    void eat();
}

public class ExampleTask {
    public static void main(String[] args) {
        AbleToEat ableToEat = new AbleToEat() {
            @Override
            public void eat() {
                System.out.println("ea");
            }
        };

        ableToEat.eat();
    }
}


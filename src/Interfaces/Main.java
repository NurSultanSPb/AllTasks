package Interfaces;

import ExceptionExamples.RobotConnection;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        long time = timer.measureTime(() -> {
            new BigDecimal("12345678911").pow(100000);
        });
        System.out.println(time);
    }
}






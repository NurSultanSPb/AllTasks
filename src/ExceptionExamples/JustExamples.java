package ExceptionExamples;

import Logging.Log1;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

public class JustExamples {
    public static void main(String[] args)  {
        Logger LOGGER;
        LOGGER = Logger.getLogger(JustExamples.class.getName());

        int[] array = new int[10];
        try {
            array[11] = 25;
        } catch (ArithmeticException arithmeticException) {
            arithmeticException.printStackTrace();
        } finally {
            System.out.println("After the try-catch");
        }
    }


}

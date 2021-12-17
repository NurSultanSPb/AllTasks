package FuncInter;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Random {
    public static void main(String[] args) {
        IntStream intStream = pseudoRandomStream(13);
        intStream.limit(20).forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> n * n / 10 % 1000);
    }
}

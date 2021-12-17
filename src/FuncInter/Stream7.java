package FuncInter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Map.Entry.<String, Long>comparingByValue().reversed()
        String str = scanner.nextLine(); //map(s -> counting.merge(s, 1, (prev, one) -> prev + one))
        //String str2 = "Мама мыла раму 33 раза, мама мама мыла 3 33 i am here once again and again and again! 3 33 i am here once again and again and again! 3 33 i am here once again and again and again!";
        String nwe = str.replaceAll("[^a-zA-Z0-9-а-яА-Я-\\s]", "");
        String[] array = nwe.split(" ");
        Map<String, Long> counting = Arrays.stream(array).map(s -> s.toLowerCase()).collect(
                Collectors.groupingBy(s -> s + "", Collectors.counting()));
        counting
                .entrySet()
                .stream()
                .sorted((s1, s2) -> s1.getKey().compareTo(s2.getKey()))
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(s -> System.out.println(s.getKey()));


    }

}

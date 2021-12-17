package FuncInter;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Stream8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            result += str + " ";
        }
        String nwe = result.replaceAll("[^а-яА-Яa-zA-Z0-9]+", " ");
        String[] array = nwe.split(" ");

        Map<String, Long> counting = Arrays
                .stream(array)
                .map(s -> s.toLowerCase())
                .collect(
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

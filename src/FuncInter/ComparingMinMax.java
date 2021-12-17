package FuncInter;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComparingMinMax {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(123,54325,456,567,768,7689,78,35,132);
        Comparator<? super Integer> comparator = Integer::compare;
        BiConsumer<? super Integer, ? super Integer> biConsumer = (x1, x2) -> System.out.println("min: " + x1 + "\nmax: " + x2);
        findMinMax(stream, comparator, biConsumer);
    }
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List <? extends T> list = stream.collect(Collectors.toList());
        list.sort(order);
        if (list.size() == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get((list.size()) - 1));
        }

    }
}

class Phone1{

    private String name;
    private int price;

    public Phone1(String name, int price){
        this.name=name;
        this.price=price;
    }
    public static int compare (Phone1 p1, Phone1 p2){
        if(p1.getPrice() > p2.getPrice())
            return 1;
        return -1;
    }
    public String getName() { return name; }
    public int getPrice() { return price;}
}
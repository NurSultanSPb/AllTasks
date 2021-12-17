package FuncInter;
import java.util.Comparator;
import java.util.stream.*;

public class SomeClass {
    public static void main(String[] args) {
        /*int[] numbers = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        int count=0;
        for(int i:numbers){

            if(i > 0) count++;
        }
        System.out.println(count);
         */
        //String[] cities = new String[]{"Париж", "Лондон", "Мадрид","Берлин", "Брюссель"};
        //Stream<String> citiesStream = Stream.of(cities);
        //citiesStream.filter(s -> s.length() > 6).forEach(s -> System.out.println(s + " adding this"));
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Nokia 9", "HMD Global",150),
                new Phone("Galaxy S9", "Samsung", 300));

        phoneStream.sorted(new PhoneComparator())
                .forEach(p->System.out.printf("%s (%s) - %d \n",
                        p.getName(), p.getCompany(), p.getPrice()));


    }
}

class PhoneComparator implements Comparator<Phone> {

    public int compare(Phone a, Phone b){

        return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
    }
}

class Phone{

    private String name;
    private String company;
    private int price;

    public Phone(String name, int price) {
        this.name=name;
        this.price = price;
    }
    public Phone(String name, String comp, int price){
        this.name=name;
        this.company=comp;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCompany() { return company; }
}


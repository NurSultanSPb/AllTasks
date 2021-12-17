package Shildt;


import java.io.Reader;
import java.util.*;

public class LastTaskCollections {
    public static void main(String[] args) {
        Map<Integer, String> states = new HashMap<Integer, String>();
        states.put(1, "Germany");
        states.put(2, "Spain");
        states.put(4, "France");
        states.put(3, "Italy");
        states.put(3, "jui");

        // получим объект по ключу 2
        String first = states.get(2);
        System.out.println(first);
        // получим весь набор ключей
        Set<Integer> keys = states.keySet();
        // получить набор всех значений
        Collection<String> values = states.values();
        //заменить элемент
        states.replace(1, "Poland");
        // удаление элемента по ключу 2
        states.remove(2);
        // перебор элементов
        for(Map.Entry<Integer, String> item : states.entrySet()){

            System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
        }

        Map<String, Person> people = new HashMap<String, Person>();
        people.put("1240i54", new Person("Tom"));
        people.put("1564i55", new Person("Bill"));
        people.put("4540i56", new Person("Nick"));

        for(Map.Entry<String, Person> item : people.entrySet()){

            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().getName());
        }
    }
    public static Map<String, Long> getSalesMap(Reader reader) {
        Map<String, Long> result = new HashMap<>();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            String[] array = scanner.nextLine().split(" ");
            if (result.containsKey(array[0])) {
                long summing = result.get(array[0]) + Long.parseLong(array[1]);
                result.put(array[0], summing);
            } else {
                result.put(array[0], Long.parseLong(array[1]));
            }
        }
        return result;
    }
}
class Person{

    private String name;
    public Person(String value){

        name=value;
    }
    String getName(){return name;}
}
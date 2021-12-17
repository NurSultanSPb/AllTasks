package Shildt;

import java.io.Reader;
import java.util.*;
abstract class PeopleOne <T> {
}
public class Project1 {

    public static void main(String[] args) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        int z = 0;
        while (scanner.hasNext()) {
            if (z % 2 != 0) {
                deque.addFirst(scanner.nextInt());
            } else {
                scanner.nextInt();
            }
            z++;
        }

        /*
        String string = scanner.nextLine();
        String[] array = string.split(" ");
        for (int i = array.length - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                deque.addLast(Integer.parseInt(array[i]));
            }
        }

         */
        for (Integer i: deque) {
            System.out.print(i + " ");
        }





    }


    public static Map<String, Long> getSalesMap(Reader reader) {
        Map<String, Long> result = new HashMap<>();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            String salesMan = scanner.next();
            long price = scanner.nextLong();
            result.merge(salesMan, price, ((aLong, aLong2) -> (aLong + aLong2)));
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


    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        HashSet<T> resultSet = new HashSet<>(set1);
        for (T el: set2) {
            if(resultSet.contains(el) == false) {
                resultSet.add(el);
            } else {
                resultSet.remove(el);
            }
        }
        return resultSet;

    }
    public static class Pair <T, V> {

        T object;
        V object2;

        private Pair (T object, V object2 ) {
            this.object = object;
            this.object2 = object2;
        }

        static <T, V> Pair of(T object, V object2) {
            return new Pair(object, object2);
        }

        T getFirst() {
            return object;
        }

        V getSecond() {
            return object2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(object, pair.object) && Objects.equals(object2, pair.object2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(object, object2);
        }
    }


    public static class DynamicArray<T> {
        private int index = 0;
        private T[] array;

        public DynamicArray() {
            array = (T[]) new Object[10];
        }

        public void add(T el){
            if(index>=array.length){
                array = Arrays.copyOf(array, array.length+10);
            }
            array[index++]=el;
        }

        public void remove(int index) {
            forIndex(index);
            helper(index);
            for (int i = index; i < array.length; i++) {
                if (i < array.length - 1) {
                    array[i] = array[i + 1];
                } else {
                    array[i] = null;
                }
            }
        }

        public T get(int index) {
            forIndex(index);
            return array[index];
        }

        public void forIndex (int index) {
            if (index >= array.length || index < 0) {
                throw new IndexOutOfBoundsException();
            }
        }

        public void helper (int index) {
            for (int i = index; i < array.length; i++) {
                if (i < array.length - 1) {
                    array[i] = array[i + 1];
                } else {
                    array[i] = null;
                }
            }
        }
    }

}

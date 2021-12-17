package FilewAndPaths;

import java.io.*;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) {

    }


    public static Animal[] deserializeAnimalArray(byte[] data) throws IllegalArgumentException {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int length = ois.readInt();
            Animal[] animals = new Animal[length];
            for (int i = 0; i < length; i++) {
                animals[i] = (Animal) ois.readObject();
            }
            return animals;
        } catch (Exception e){
            throw new IllegalArgumentException();
        }
    }
}

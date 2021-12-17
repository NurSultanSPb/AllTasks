package FilewAndPaths;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Objects;

public class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
    public static Animal[] deserializeAnimalArray(byte[] data) throws IllegalArgumentException {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int length = ois.readInt();
            Animal[] animals = new Animal[length];
            for (int i = 0; i < length; i++) {
                animals[i] = (Animal) ois.readObject();
            }
            return animals;
        } catch (OptionalDataException e){
            throw new IllegalArgumentException();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}

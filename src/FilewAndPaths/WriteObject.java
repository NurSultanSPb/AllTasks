package FilewAndPaths;

import java.io.*;

public class WriteObject {
    public static void main(String[] args) {
        Person[] people = {new Person(1, "Bob"), new Person(2, "Got"), new Person(5, "G22ot")};
        try {
            FileOutputStream fos = new FileOutputStream("people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(people);

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

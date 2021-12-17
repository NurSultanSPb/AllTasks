package FilewAndPaths;

import java.io.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.util.*;

import java.io.*;
import java.nio.*;
import java.util.*;

public class FilesOne {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double result = 0.0;
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                result += Double.parseDouble(scanner.next());
            } else {
                scanner.next();
            }
        }
        scanner.close();
        System.out.printf("%.6f", result);
    }
}

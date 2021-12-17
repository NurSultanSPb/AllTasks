package Prepare;

public class Example1 {
    public static void main(String[] args) {
        try {
            System.out.println("Метод Main успешно запущен");
            m1();
            System.out.println("Метод Main заканчивает свою работу");
        } catch (Exception e) {
            StackTraceElement[] elements = e.getStackTrace();
            if (elements.length > 3) {
                System.out.println(elements[2].getClassName() + "#" + elements[2].getMethodName());
            } else {
                System.out.println("null");
            }
        }
    }

    static void m1() {
            System.out.println("Первый метод передаёт привет!(m1)");
            m2();
        System.out.println("Первый метод пости успешно отработал");
    }

    static void m2() {
        System.out.println("Второй метод передаёт привет(m2)");
        int a = 6;
        int b = 0;
        System.out.println(a/b);
        System.out.println("Второй метод почти усрпешно отработал(m2)");
    }
}
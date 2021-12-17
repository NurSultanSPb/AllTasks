package com.company;

public class Example {
    public static void main(String[] args) {
        BlackBox object2 = new BlackBox(5, 10);
        BlackBox object1 = new BlackBox(50, 10);
        System.out.println(object1.equals(object2));
        //метод equals сравнивает ссылки, а не содержание
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());
        System.out.println(31*36 + 10);
        System.out.println(object1.hashCode() == object2.hashCode());
    }
}

class BlackBox {
    int varA;
    int varB;

    BlackBox(int varA, int varB){
        this.varA = varA;
        this.varB = varB;
    }
    @Override //переопределение метода хэшкод
    public int hashCode() {
        final int prime = 31;//произвольное число
        int result = 1;//произвольное число
        result = prime * result + varA; //генерация результата уже с учетом содержимого
        result = prime * result + varB; // генерация результата с учетом второй переменной
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) //если ссылки одинаковые, объекты одинаковые
            return true;
        if (obj == null) //если объект объ налл(пустая ссылка), то не равны
            return false;
        if (getClass() != obj.getClass())//если второй объект не является объектом этого класса, не равны
            return false;
        BlackBox other = (BlackBox) obj; //приведение к типу/классу
        if (varA != other.varA) //сравнение переменных, переменной первой
            return false;
        if (varB != other.varB) //сравнение второй переменной
            return false;
        return true;
    }
}

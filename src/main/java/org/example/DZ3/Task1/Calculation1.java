package org.example.DZ3.Task1;

//1. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
//sum(), multiply(), divide(), subtract().
//Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
//Методы должны возвращать результат своей работы.



public class Calculation1 {
    private static final Operations<Number, Number> SUMMATION = new Summation();
    private static final Operations<Number, Number> SUBTRACTION = new Subtraction();
    private static final Operations<Number, Number> MULTIPLICATION = new Multiplication();
    private static final Operations<Number, Number> DIVISION = new Division();

    public static <T extends Number, U extends Number> Double sum(T a, U b) {
        return SUMMATION.action(a, b);
    }

    public static <T extends Number, U extends Number> Double subtract(T a, U b) {
        return SUBTRACTION.action(a, b);
    }

    public static <T extends Number, U extends Number> Double multiply(T a, U b) {
        return MULTIPLICATION.action(a, b);
    }

    public static <T extends Number, U extends Number> Double divide(T a, U b) {
        return DIVISION.action(a, b);
    }



    public static void main(String[] args) {
        System.out.println("------------------------sum------------------------");
        System.out.println(sum(5, 6));
        System.out.println(sum(5, 6.8));
        System.out.println(sum(5.5, 6.9));
        System.out.println("------------------------subtract------------------------");
        System.out.println(subtract(5, 6));
        System.out.println(subtract(5, 6.8));
        System.out.println(subtract(5.5, 6.9));
        System.out.println("------------------------multiply------------------------");
        System.out.println(multiply(5, 6));
        System.out.println(multiply(5, 6.8));
        System.out.println(multiply(5.5, 6.9));
        System.out.println("------------------------division------------------------");
        System.out.println(divide(5, 6));
        System.out.println(divide(5, 6.8));
        try {
            System.out.println(divide(5.5, 0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

interface Operations<T extends Number, U extends Number> {
    Double action(T a, U b);
}


class Summation implements Operations<Number, Number> {
    @Override
    public Double action(Number a, Number b) {
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();
        return num1 + num2;
    }
}
class Subtraction implements Operations<Number, Number> {
    @Override
    public Double action(Number a, Number b) {
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();
        return num1 - num2;
    }
}
class Multiplication implements Operations<Number, Number> {
    @Override
    public Double action(Number a, Number b) {
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();
        return num1 * num2;
    }
}
class Division implements Operations<Number, Number> {
    @Override
    public Double action(Number a, Number b) {
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();
        if (num2 == 0) {
            throw new ArithmeticException("На нуль делить нельзя");
        }
        return num1 / num2;
    }
}


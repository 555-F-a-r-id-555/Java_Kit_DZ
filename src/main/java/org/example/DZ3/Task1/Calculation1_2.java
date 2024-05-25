package org.example.DZ3.Task1;

/**
 * Calculation1_2 тот же класс что и Calculation1 только без дженериков
 */
public class Calculation1_2 {
    private static final Operations2 SUMMATION = new Summation2();
    private static final Operations2 SUBTRACTION = new Subtraction2();
    private static final Operations2 MULTIPLICATION = new Multiplication2();
    private static final Operations2 DIVISION = new Division2();

    public static Double sum2(Number a, Number b) {
        return SUMMATION.action(a, b);
    }

    public static Double subtract2(Number a, Number b) {
        return SUBTRACTION.action(a, b);
    }

    public static Double multiply2(Number a, Number b) {
        return MULTIPLICATION.action(a, b);
    }

    public static Double divide2(Number a, Number b) {
        return DIVISION.action(a, b);
    }

    public static void main(String[] args) {
        System.out.println("------------------------sum------------------------");
        System.out.println(sum2(5, 6));
        System.out.println(sum2(5, 6.8));
        System.out.println(sum2(5.5, 6.9));
        System.out.println("------------------------subtract------------------------");
        System.out.println(subtract2(5, 6));
        System.out.println(subtract2(5, 6.8));
        System.out.println(subtract2(5.5, 6.9));
        System.out.println("------------------------multiply------------------------");
        System.out.println(multiply2(5, 6));
        System.out.println(multiply2(5, 6.8));
        System.out.println(multiply2(5.5, 6.9));
        System.out.println("------------------------division------------------------");
        System.out.println(divide2(5, 6));
        System.out.println(divide2(5, 6.8));
        try {
            System.out.println(divide2(5.5, 0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

interface Operations2 {
    Double action(Number a, Number b);
}

class Summation2 implements Operations2 {
    @Override
    public Double action(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }
}

class Subtraction2 implements Operations2 {
    @Override
    public Double action(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }
}

class Multiplication2 implements Operations2 {
    @Override
    public Double action(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }
}

class Division2 implements Operations2 {
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


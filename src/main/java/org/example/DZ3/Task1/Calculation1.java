package org.example.DZ3.Task1;

//1. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
//sum(), multiply(), divide(), subtract().
//Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
//Методы должны возвращать результат своей работы.



public class Calculation1 {
    public static <T extends Number, U extends Number> Double sum(T a, U b) {
        Operations<Number, Number> summation = new Summation();
        return summation.action(a, b);
    }
    public static <T extends Number, U extends Number> Double subtract(T a, U b) {
        Operations<Number, Number> subtraction = new Subtraction();
        return subtraction.action(a, b);
    }

    public static <T extends Number, U extends Number> Double multiply(T a, U b) {
        Operations<Number, Number> multiplication = new Multiplication();
        return multiplication.action(a, b);
    }

    public static <T extends Number,U extends Number> Double divide(T a,U b){
        Operations<Number,Number> division = new Dividition();
        return division.action(a,b);
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
        System.out.println(divide(5.5, 0));
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
class Dividition implements Operations<Number, Number> {
    @Override
    public Double action(Number a, Number b) {
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();
        if(num2!=0){
            return num1 / num2;
        }
        System.out.println("На нуль делить нельзя");
        return -0.0;
    }
}


package org.example.DZ3.Task1;

public class Calculation2 {
    public static <T extends Number, U extends Number> double sum(T t, U u) {
        double num1 = t.doubleValue();
        double num2 = u.doubleValue();
        return num1 + num2;
    }
    public static <T extends Number, U extends Number> double subtract(T t, U u) {
        double num1 = t.doubleValue();
        double num2 = u.doubleValue();
        return num1 - num2;
    }

    public static <T extends Number, U extends Number> double multiply(T t, U u) {
        double num1 = t.doubleValue();
        double num2 = u.doubleValue();
        return num1 * num2;
    }

    public static <T extends Number, U extends Number> double divide(T t, U u) {
        double num1 = t.doubleValue();
        double num2 = u.doubleValue();
        if (num2 != 0) {
            return num1 / num2;
        }
        System.out.println("На нуль делить нельзя");
        return -0.0;
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

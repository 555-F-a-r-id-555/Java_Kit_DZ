package org.example.DZ3.Task1;

/**
 * Этот вариант более компактный и простой.
 * Все операции определены в виде статических методов в одном классе.
 *
 * Преимущества:
 *
 * Простота и краткость: Меньше кода, все операции находятся в одном классе.
 * Легкость использования: Простой в использовании, нет необходимости создавать дополнительные классы.
 * Скорость реализации: Быстрее реализовать и понять для простых случаев использования.
 * Недостатки:
 *
 * Менее модульный: Все операции находятся в одном классе, что может затруднить расширение функциональности.
 * Меньше гибкости: Добавление новых операций требует изменения основного класса, что увеличивает риск внесения ошибок.
 * Отсутствие возможности различать разные стратегии выполнения операций: Все операции выполняются одинаково.
 */

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
        if (num2 == 0) {
            throw new ArithmeticException("На нуль делить нельзя");
        }
        return num1 / num2;
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

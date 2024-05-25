package org.example.DZ3.Task3;

//3. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
/*
1. Иммутабельность: Поля record класса автоматически являются final и не могут быть изменены после создания объекта.
2. Автоматическое создание методов: Для record классов автоматически генерируются методы equals(), hashCode(), toString(), а также методы доступа (геттеры) для каждого поля.
3. Простота синтаксиса: Объявление record класса значительно короче по сравнению с традиционными классами.
4. Невозможность наследования: Record классы не могут наследоваться от других классов и не могут быть суперклассами.
    Они могут реализовывать интерфейсы.
 */


public record Pair2<T1, T2>(T1 first, T2 second) {
    // Конструктор, геттеры, equals(), hashCode() и toString() генерируются автоматически


    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public void display() {
        System.out.println("First: " + first + ", Second: " + second);
    }

    @Override
    public String toString() {
        return "Pair with first=" + first + " and second=" + second;
    }
}


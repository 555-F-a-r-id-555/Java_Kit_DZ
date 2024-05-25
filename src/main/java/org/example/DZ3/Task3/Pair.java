package org.example.DZ3.Task3;

//3. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
//Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
//а также переопределение метода toString(), возвращающее строковое представление пары.
// Работу сдать в виде ссылки на гит репозиторий.

public class Pair<T1, T2> {

    private final T1 first;
    private final T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}

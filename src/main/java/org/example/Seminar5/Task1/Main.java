package org.example.Seminar5.Task1;

/**
 * Задание 1
 * В рамках выполнения задачи необходимо:
 *1.  ● Создать два класс ObjectA, ObjectB
 *2.  ● Реализовать класс в котором два потока при запуске провоцируют DeadLock для
 * объектов ObjectA, ObjectB
 */

/**
 * Для создания ситуации deadlock (взаимной блокировки) в многопоточном Java приложении,
 * нам нужно организовать так, чтобы два потока пытались одновременно захватить два разных ресурса в противоположных порядках.
 * В этом случае, каждый поток будет ждать освобождения ресурса, захваченного другим потоком, что приведет к состоянию deadlock.
 */

public class Main {
    public static void main(String[] args) {
        ObjectA objectA = new ObjectA("Поток A");
        ObjectB objectB = new ObjectB("Поток B");

        Thread thread1 = new Thread(objectA);
        Thread thread2 = new Thread(objectB);

        thread1.start();
        thread2.start();

//        System.out.println(thread1.currentThread().getName());

    }
}

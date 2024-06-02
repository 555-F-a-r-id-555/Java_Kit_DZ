package org.example.Seminar5Task3;

import java.util.concurrent.CountDownLatch;

/**
 *Задание 3
 * В рамках выполнения задачи необходимо:
 * 1. ● 3 бегуна должны прийти к старту гонки
 * 2. ● Программа должна гарантировать, что гонка начнется только когда все три
 * участника будут на старте
 * 3. ● Программа должна отсчитать “На старт”, “Внимание”, “Марш”
 * 4. ● Программа должна завершиться когда все участники закончат гонку.
 * 5. ● Подумайте об использовании примитива синхронизации
 */

public class Main {
    public static void main(String[] args) {

        int numberOfRunners = 3;
        CountDownLatch readyLatch = new CountDownLatch(numberOfRunners);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch finishLatch = new CountDownLatch(numberOfRunners);

        Runner A = new Runner("A",readyLatch,startLatch,finishLatch);
        Runner B = new Runner("B",readyLatch,startLatch,finishLatch);
        Runner C = new Runner("C",readyLatch,startLatch,finishLatch);

        Thread thA =new Thread(A);
        Thread thB =new Thread(B);
        Thread thC =new Thread(C);

        thA.start();
        thB.start();
        thC.start();

        try {
            readyLatch.await(); // Ждём, пока все бегуны будут готовы
            System.out.println("На старт");
            Thread.sleep(1000);
            System.out.println("Внимание");
            Thread.sleep(1000);
            System.out.println("Марш!");
            startLatch.countDown(); // Даем сигнал на старт
            finishLatch.await(); // Ждём, пока все бегуны финишируют
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

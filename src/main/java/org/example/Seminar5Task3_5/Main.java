package org.example.Seminar5Task3_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
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
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                // Отсчет перед началом гонки
                System.out.println("На старт");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Внимание");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Марш!");
            }
        });

        Thread runnerA = new Thread(new Runner("Runner A", barrier));
        Thread runnerB = new Thread(new Runner("Runner B", barrier));
        Thread runnerC = new Thread(new Runner("Runner C", barrier));

        runnerA.start();
        runnerB.start();
        runnerC.start();

        try {
            runnerA.join();
            runnerB.join();
            runnerC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Гонка завершена!");
    }
}

class Runner implements Runnable {
    private String name;
    private CyclicBarrier barrier;

    public Runner(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " на старте.");
            barrier.await(); // Ждем, пока все бегуны не будут готовы
            // Симуляция бега
            Thread.sleep((long) (Math.random() * 10000)); // Бегун бежит от 0 до 10 секунд
            System.out.println(name + " финишировал!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}


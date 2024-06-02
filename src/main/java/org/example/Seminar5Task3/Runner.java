package org.example.Seminar5Task3;

import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable{
    private String name;
    private CountDownLatch readyLatch;
    private CountDownLatch startLatch;
    private CountDownLatch finishLatch;

    public Runner(String name, CountDownLatch readyLatch, CountDownLatch startLatch, CountDownLatch finishLatch) {
        this.name = name;
        this.readyLatch = readyLatch;
        this.startLatch = startLatch;
        this.finishLatch = finishLatch;
    }


    @Override
    public void run() {
        try {
            arriveAtStart();
            startLatch.await(); // Ждём сигнала на старт
            // Симуляция бега
            Thread.sleep((long)(Math.random() *100)); // Бегун бежит от 0 до 10 секунд
            System.out.println(name + " финишировал!");
            finishLatch.countDown(); // Сообщаем, что бегун финишировал
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void arriveAtStart() {
        System.out.println(name + " на старте.");
        readyLatch.countDown(); // Сообщаем, что бегун готов
    }
}

package org.example.Seminar5.Task3V2;

public class Race {
    private final int totalRunners;
    private int readyRunners = 0;
    private boolean raceStarted = false;

    public Race(int totalRunners) {
        this.totalRunners = totalRunners;
    }

    public synchronized void runnerReady() throws InterruptedException {
        readyRunners++;
        if (readyRunners == totalRunners) {
            // Все бегуны готовы, начинаем гонку
            System.out.println("На старт");
            Thread.sleep(1000);
            System.out.println("Внимание");
            Thread.sleep(1000);
            System.out.println("Марш!");
            raceStarted = true;
            notifyAll(); // Уведомляем всех бегунов о старте гонки
        } else {
            // Ждем, пока все бегуны будут готовы
            while (!raceStarted) {
                wait();
            }
        }
    }

}

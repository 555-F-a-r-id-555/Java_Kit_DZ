package org.example.Seminar5.Task3V2;

/**
 * Задание 3
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
        Race race = new Race(3);

        Runner runnerA = new Runner(race, "A");
        Runner runnerB = new Runner(race, "B");
        Runner runnerC = new Runner(race, "C");


        Thread thA = new Thread(runnerA);
        Thread thB = new Thread(runnerB);
        Thread thC = new Thread(runnerC);

        thA.start();
        thB.start();
        thC.start();

        try {
            thA.join();
            thB.join();
            thC.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Гонка завершена!");

    }
}

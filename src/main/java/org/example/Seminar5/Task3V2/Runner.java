package org.example.Seminar5.Task3V2;

public class Runner implements Runnable {
    private String name;
    private final Race race;

    public Runner(Race race, String name) {
        this.race = race;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " на старте.");
            race.runnerReady();
            // Симуляция бега
            Thread.sleep((long) (Math.random() * 10000)); // Бегун бежит от 0 до 10 секунд
            System.out.println(name + " финишировал!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

package org.example.DZ5.SecondVersion;

class Philosopher implements Runnable {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private int eatCount = 0;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() {
        System.out.println("Философ " + id + " думает.");
        try {
            Thread.sleep(((int) (Math.random() * 100)));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void eat() {
        System.out.println("Философ " + id + " кушает.");
        try {
            Thread.sleep(((int) (Math.random() * 100)));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void pickUpForks() {
        while (true) {
            if (leftFork.pickUp()) {
                System.out.println("Философ " + id + " взял левую вилку " + leftFork.getId());
                if (rightFork.pickUp()) {
                    System.out.println("Философ " + id + " взял правую вилку " + rightFork.getId());
                    return;
                } else {
                    leftFork.putDown();
                    System.out.println("Философ " + id + " положил левую вилку " + leftFork.getId());
                }
            }
            // Ждем немного перед повторной попыткой
            try {
                Thread.sleep(((int) (Math.random() * 10)));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void putDownForks() {
        leftFork.putDown();
        rightFork.putDown();
        System.out.println("Философ " + id + " положил вилки " + leftFork.getId() + " и " + rightFork.getId());
    }

    @Override
    public void run() {
        while (eatCount < 3) {
            think();
            pickUpForks();
            eat();
            putDownForks();
            eatCount++;
        }
    }
}

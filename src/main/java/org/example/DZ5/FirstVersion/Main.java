package org.example.DZ5.FirstVersion;
/**
 * 1.Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
 * 2.Вилки лежат на столе между каждой парой ближайших философов.
 * 3.Каждый философ может либо есть, либо размышлять.
 * 4.Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
 * 5.Философ не может есть два раза подряд, не прервавшись на размышления
 * 6.Можно брать только две вилки одновременно
 *
 *
 * Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
 */

//  TODO: в этой версии несколько философов могут взять одну и ту же вилку - вариант, использовать volatile
/*
Философ 2 думает.
Философ 1 думает.
Философ 0 думает.
Философ 2 взял левую вилку 2
Философ 0 взял левую вилку 0
Философ 0 взял правую вилку 1
Философ 2 взял правую вилку 0
Философ 0 кушает.
Философ 2 кушает.
 */

public class Main {
    public static void main(String[] args) {
        int numPhilosophers = 3;
        int howManyTimesShouldIEat = 3;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Fork[] forks = new Fork[numPhilosophers];

        Thread[] threads = new Thread[numPhilosophers];
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < numPhilosophers; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % numPhilosophers];
            philosophers[i] = new Philosopher(i, leftFork, rightFork);
            threads[i] = new Thread(philosophers[i]);
            threads[i].start();
        }


        try {
            for (int i = 0; i < numPhilosophers; i++) {
                threads[i].join();
                if (!threads[i].isAlive()) {
                    System.out.println("\n Философ " + i + " покушал " + howManyTimesShouldIEat + " раз(а) и наелся !) \n");
                }
            }
            System.out.println("\n Все Философы наелись!) \n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

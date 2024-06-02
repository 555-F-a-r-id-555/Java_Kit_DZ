package org.example.Seminar5.Task1;

class DeadlockExample implements Runnable {
    private final String name;
    private final Object lock1;
    private final Object lock2;

    public DeadlockExample(String name, Object lock1, Object lock2) {
        this.name = name;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(name + " захватил " + lock1);
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            synchronized (lock2) {
                System.out.println(name + " захватил " + lock2);
            }
        }
    }

    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();

        DeadlockExample t1 = new DeadlockExample("Thread1", lockA, lockB);
        DeadlockExample t2 = new DeadlockExample("Thread2", lockB, lockA);

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);

        thread1.start();
        thread2.start();
    }
}
package org.example.Seminar5.Task1;

public class ObjectB implements Runnable{
    private final String nameB;
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public ObjectB(String nameB) {
        this.nameB = nameB;
    }

    @Override
    public void run() {
        synchronized (lock2) {
            System.out.println(nameB + " захватил lock2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            synchronized (lock1) {
                System.out.println(nameB + " захватил lock1");
            }
        }
    }
}

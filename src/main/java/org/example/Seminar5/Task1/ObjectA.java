package org.example.Seminar5.Task1;

public class ObjectA implements Runnable{
    private final String nameA;
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();


    public ObjectA(String nameA) {
        this.nameA = nameA;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(nameA + " захватил lock1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            synchronized (lock2) {
                System.out.println(nameA + " захватил lock2");
            }
        }
    }
}

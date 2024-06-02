package org.example.DZ5.SecondVersion;

public class Fork {
    private final int id;
    private volatile boolean isAvailable = true;

    public Fork(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public synchronized boolean pickUp() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public synchronized void putDown() {
        isAvailable = true;
    }
}

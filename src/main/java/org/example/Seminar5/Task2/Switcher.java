package org.example.Seminar5.Task2;

public class Switcher {

    private volatile boolean switcher = false;

    public void setSwitcher(boolean switcher) {
        this.switcher = switcher;
    }

    public boolean getSwitcher() {
        return switcher;
    }

//    public boolean isSwitched() {// для B
//        return switcher;
//    }
}

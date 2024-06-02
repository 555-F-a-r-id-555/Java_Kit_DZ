package org.example.Seminar5.Task2;

public class A  implements Runnable{
    private String nameA;
    private Switcher switcher;

    public A(String nameA, Switcher switcher) {
        this.nameA = nameA;
        this.switcher = switcher;
    }

    @Override
    public void run() {
        while (true) {
            try {
                switcher.setSwitcher(!switcher.getSwitcher());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

//public class A implements Runnable {
//    private String nameA;
//    private Switcher switcher;
//
//    public A(String nameA, Switcher switcher) {
//        this.nameA = nameA;
//        this.switcher = switcher;
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            switcher.setSwitched(true);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            switcher.setSwitched(false);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//
//    }
//}

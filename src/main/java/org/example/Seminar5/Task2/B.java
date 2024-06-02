package org.example.Seminar5.Task2;

public class B implements Runnable {
    private String nameB;
    private Switcher switcher;


    public B(String nameB, Switcher switcher) {
        this.nameB = nameB;
        this.switcher = switcher;
    }

    @Override
    public void run() {
        int res = 100;
        while (res > 0) {
            if (switcher.getSwitcher()) {
                res--;
                System.out.println("res= " + res);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}

//public class B implements Runnable {
//    private String nameB;
//    private Switcher switcher;
//
//    public B(String nameB, Switcher switcher) {
//        this.nameB = nameB;
//        this.switcher = switcher;
//    }
//
//    @Override
//    public void run() {
//
//        while (true) {
//            if (switcher.isSwitched() == true) {
//                for (int i = 100; i >= 0; i--) {
//                    System.out.println("i = " + i);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    if (!switcher.isSwitched()) {
//                        break; // Приостанавливаем отсчёт, если switcher переключился в false
//                    }
//                }
//                if (switcher.isSwitched()) {
//                    System.out.println("Countdown finished!");
//                    break; // Завершаем выполнение, если обратный отсчет завершен
//                }
//            }else {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//        }
//
//    }
//}

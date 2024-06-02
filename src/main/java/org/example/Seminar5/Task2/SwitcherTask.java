package org.example.Seminar5.Task2;

public class SwitcherTask {

    private volatile boolean switcher = false; // Переменная для переключения состояния

    public static void main(String[] args) {
        SwitcherTask task = new SwitcherTask();
        task.start();
    }

    public void start() {
        Thread threadA = new Thread(new SwitcherChanger());
        Thread threadB = new Thread(new Counter());

        threadA.start();
        threadB.start();
    }

    private class SwitcherChanger implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }

                switcher = !switcher; // Меняем состояние переменной switcher
                System.out.println("Switcher changed to: " + switcher);
            }
        }
    }

    private class Counter implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (switcher) { // Проверяем состояние переменной switcher
                    for (int i = 100; i >= 0; i--) {
                        System.out.println("Countdown: " + i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }

                        if (!switcher) {
                            break; // Приостанавливаем отсчёт, если switcher переключился в false
                        }
                    }
                    if (switcher) {
                        System.out.println("Countdown finished!");
                        break;
                    }
                }
            }
        }
    }
}

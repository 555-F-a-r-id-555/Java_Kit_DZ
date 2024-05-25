package org.example.DZ3.Task3;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------Pair-----------------------");
        Pair<Integer, String> pair = new Pair<>(1, "second");
        System.out.println("First: " + pair.getFirst());
        System.out.println("Second: " + pair.getSecond());
        System.out.println(pair);


        System.out.println("------------------------record Pair2-----------------------");
        Pair2<String, String> pair2 = new Pair2<>("первое значение", "второе значение");
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
        System.out.println(pair2);
        pair2.display();
    }
}

package org.example.DZ3.Task2;

import java.util.ArrayList;
import java.util.Collections;

//2. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
//если они одинаковые, и false в противном случае.
//Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа по парно по индексам.
public class ArrayComparator {

    public static ArrayList<Integer> arrayListA;
    public static ArrayList<Integer> arrayListA2;
    public static ArrayList<Double> arrayListB;

    public static ArrayList<String> arrayListC;
    public static ArrayList<String> arrayListC2;
    public static ArrayList<Character> arrayListD;


//    public static boolean compareArrays(ArrayList a, ArrayList b) {
//        if (a.size() == b.size()) {
//            for (int i = 0; i < a.size() - 1; i++) {
//                if ((a.get(i) instanceof Number) != (b.get(i) instanceof Number)) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }

    public static <T1, T2> boolean compareArrays(ArrayList<T1> a, ArrayList<T2> b) {
        if (a.size() == b.size()) {
            for (int i = 0; i < a.size(); i++) {
                Class<?> classA = a.get(i).getClass();
                Class<?> classB = b.get(i).getClass();

//                if (!(classA.equals(classB))) {
//                    return false;
//                }
                if (!(classA.isInstance(b.get(i)) && classB.isInstance(a.get(i)))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static <T1, T2> boolean comparisonBySubtype(ArrayList<T1> a, ArrayList<T2> b) {
        if (a.size() == b.size()) {
            Class<?> classNumber = Number.class;
            Class<?> classCharSequence = CharSequence.class;

            for (int i = 0; i < a.size(); i++) {
                Class<?> classA = a.get(i).getClass();
                Class<?> classB = b.get(i).getClass();

                if (!(classNumber.isAssignableFrom(classA) && classNumber.isAssignableFrom(classB))
                        && !(classCharSequence.isAssignableFrom(classA) && classCharSequence.isAssignableFrom(classB))
                ) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }



    public static void main(String[] args) {

        arrayListA = new ArrayList<>();
        arrayListA2 = new ArrayList<>();

        arrayListB = new ArrayList<>();
        arrayListC = new ArrayList<>();
        arrayListC2 = new ArrayList<>();
        arrayListD = new ArrayList<>();


        Integer[] integer1 = {1, 2, 3, 4, 5};
        Collections.addAll(arrayListA, integer1);

        Integer[] integer2 = {11, 21, 31, 41, 51};
        Collections.addAll(arrayListA2, integer2);

        Double[] double1 = {1.5, 2.8, 3.9, 4.0, 5.0};
        Collections.addAll(arrayListB, double1);

        String[] string1 = {"Первый", "Второй", "Третей", "Четвертый", "Пятый"};
        Collections.addAll(arrayListC, string1);

        String[] string2 = {"Первый-1", "Второй-2", "Третей-3", "Четвертый-4", "Пятый-5"};
        Collections.addAll(arrayListC2, string2);

        Character[] char1 = {'П', 'В', 'Т', 'Ч', 'П'};
        Collections.addAll(arrayListD, char1);


        System.out.println("------------------------compareArrays-----------------------");
        System.out.println("------------------------a-Integer-b-Double-----------------------");
        System.out.println(compareArrays(arrayListA, arrayListB));
        System.out.println("------------------------a-Integer-b-Integer-----------------------");
        System.out.println(compareArrays(arrayListA, arrayListA2));
        System.out.println("------------------------a-String-b-Character-----------------------");
        System.out.println(compareArrays(arrayListC, arrayListD));
        System.out.println("------------------------a-Integer-b-String-----------------------");
        System.out.println(compareArrays(arrayListA, arrayListC));
        System.out.println("------------------------a-String-b-String-----------------------");
        System.out.println(compareArrays(arrayListC, arrayListC2));


        System.out.println("------------------------comparisonBySubtype-----------------------");
        System.out.println("------------------------a-Integer-b-Double-----------------------");
        System.out.println(comparisonBySubtype(arrayListA, arrayListB));
        System.out.println("------------------------a-Integer-b-Integer-----------------------");
        System.out.println(comparisonBySubtype(arrayListA, arrayListA2));
        System.out.println("------------------------a-String-b-Character-----------------------");
        System.out.println(comparisonBySubtype(arrayListC, arrayListD));
        System.out.println("------------------------a-Integer-b-String-----------------------");
        System.out.println(comparisonBySubtype(arrayListA, arrayListC));
        System.out.println("------------------------a-String-b-String-----------------------");
        System.out.println(comparisonBySubtype(arrayListC, arrayListC2));

    }
}

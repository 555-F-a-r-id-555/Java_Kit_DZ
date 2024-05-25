package org.example.DZ3.Task2;

import java.util.*;
//2. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
//если они одинаковые, и false в противном случае.
//Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа по парно по индексам.

public class ArrayComparator3 {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    static Number[] arrInt1;
    static Number[] arrInt2;
    static Number[] arrDouble1;
    static String[] arrString1;
    static String[] arrString2;
    static Character[] arrChar;


    public static <T, U> boolean compareArrays(T[] array1, U[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!areSameTypeAndEqual(array1[i], array2[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean areSameTypeAndEqual(Object obj1, Object obj2) {
        Class<?> classA = obj1.getClass();
        Class<?> classB = obj2.getClass();
//        System.out.println(classA.equals(classB));
        return classA.equals(classB);
    }


    public static <T, U> boolean compareArraysByNumber(T[] array1, U[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!areSameTypeByNumber(array1[i], array2[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean areSameTypeByNumber(Object obj1, Object obj2) {
        Class<?> classNumber = Number.class;
        Class<?> classA = obj1.getClass();
        Class<?> classB = obj2.getClass();
//        System.out.println(classNumber.isAssignableFrom(classA) && classNumber.isAssignableFrom(classB));
//        return (classNumber.isAssignableFrom(classA) && classNumber.isAssignableFrom(classB)
//                || (classA.isAssignableFrom(classB)));
        return ( ((obj1 instanceof Number) && (obj2 instanceof Number))
                || (classA.equals(classB)));

    }


    public static void main(String[] args) {

        Random rand = new Random();

        arrInt1 = generateRandomIntArray(rand, 5, 10);
        arrInt2 = generateRandomIntArray(rand, 5, 10);
        arrDouble1 = generateRandomDoubleArray(rand, 5, 10);
        arrString1 = generateRandomStringArray(rand, 5, 10);
        arrString2 = generateRandomStringArray(rand, 5, 10);
        arrChar = generateRandomCharArray(rand, 5);

        System.out.println("Random Integers 1: " + Arrays.toString(arrInt1));
        System.out.println("Random Integers 2: " + Arrays.toString(arrInt2));
        System.out.println("Random Doubles: " + Arrays.toString(arrDouble1));
        System.out.println("Random Strings 1: " + Arrays.toString(arrString1));
        System.out.println("Random Strings 2: " + Arrays.toString(arrString2));
        System.out.println("Random Characters: " + Arrays.toString(arrChar));


        System.out.println("------------------------compareArrays-----------------------");
        System.out.println("------------------------a-Integer-b-Integer-----------------------");
        System.out.println(compareArrays(arrInt1, arrInt2));
        System.out.println("------------------------a-Integer-b-Double-----------------------");
        System.out.println(compareArrays(arrInt1, arrDouble1));
        System.out.println("------------------------a-Integer-b-String-----------------------");
        System.out.println(compareArrays(arrInt1, arrString1));
        System.out.println("------------------------a-String-b-String-----------------------");
        System.out.println(compareArrays(arrString1, arrString2));
        System.out.println("------------------------a-String-b-Char-----------------------");
        System.out.println(compareArrays(arrString1, arrChar));
        System.out.println("\n------------------------------------------------------------------");

        System.out.println("------------------------compareArraysByNumber-----------------------");
        System.out.println("------------------------a-Integer-b-Integer-----------------------");
        System.out.println(compareArraysByNumber(arrInt1, arrInt2));
        System.out.println("------------------------a-Integer-b-Double-----------------------");
        System.out.println(compareArraysByNumber(arrInt1, arrDouble1));
        System.out.println("------------------------a-Integer-b-String-----------------------");
        System.out.println(compareArraysByNumber(arrInt1, arrString1));
        System.out.println("------------------------a-String-b-String-----------------------");
        System.out.println(compareArraysByNumber(arrString1, arrString2));
        System.out.println("------------------------a-String-b-Char-----------------------");
        System.out.println(compareArraysByNumber(arrString1, arrChar));
        System.out.println("------------------------a-Char-b-Char-----------------------");
        System.out.println(compareArraysByNumber(arrChar, arrChar));

    }


    private static Number[] generateRandomIntArray(Random rand, int length, int bound) {
        Number[] arr = new Number[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(bound);
        }
        return arr;
    }

    private static Number[] generateRandomDoubleArray(Random rand, int length, int bound) {
        Number[] arr = new Number[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextDouble() * bound;
        }
        return arr;
    }

    private static String[] generateRandomStringArray(Random rand, int length, int stringLength) {
        String[] arr = new String[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = generateRandomString(rand, stringLength);
        }
        return arr;
    }

    private static Character[] generateRandomCharArray(Random rand, int length) {
        Character[] arr = new Character[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (rand.nextInt(26) + 'a');
        }
        return arr;
    }

    private static String generateRandomString(Random rand, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHABET.charAt(rand.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

}
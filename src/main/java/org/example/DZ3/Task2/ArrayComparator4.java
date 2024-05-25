package org.example.DZ3.Task2;

import java.util.Arrays;
import java.util.Random;

public class ArrayComparator4 {

    public static <T, U> boolean compareArrays(T[] array1, U[] array2) {
        if (array1 == null || array2 == null || array1.length != array2.length) {
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
        return classA.equals(classB);
    }


    public static <T, U> boolean compareArraysByNumber(T[] array1, U[] array2) {
        if (array1 == null || array2 == null || array1.length != array2.length) {
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
        return (((obj1 instanceof Number) && (obj2 instanceof Number))
                || (classA.equals(classB)));

    }


    public static void main(String[] args) {

        Number[] arr1 = new Number[5];

        arr1[0] = 1;
        arr1[1] = 2.5;
        arr1[2] = 3.14f;
        arr1[3] = 4L;
        arr1[4] = 5.0;

        System.out.println( "arr1 =" + Arrays.toString(arr1));

        Number[] arr2 = new Number[5];

        arr2[0] = 5;
        arr2[1] = 5.5;
        arr2[2] = 5.14f;
        arr2[3] = 5L;
        arr2[4] = 5.0;

        System.out.println("arr2 =" + Arrays.toString(arr2));


        Number[] arr3 = new Number[5];

        arr3[0] = 1.9;
        arr3[1] = 2;
        arr3[2] = 3.14f;
        arr3[3] = 4L;
        arr3[4] = 5;

        System.out.println("arr3 =" + Arrays.toString(arr3));


        String[] arr4 = new String[5];

        arr4[0] = "1";
        arr4[1] = "2";
        arr4[2] = "3.14f";
        arr4[3] = "4L";
        arr4[4] = "5";

        System.out.println("arr4 =" + Arrays.toString(arr4));

        String[] arr5 = new String[5];

        arr5[0] = "first";
        arr5[1] = "second";
        arr5[2] = "third";
        arr5[3] = "fourth";
        arr5[4] = "sixth";

        System.out.println("arr5 =" + Arrays.toString(arr5));


        System.out.println("------------------------compareArrays-----------------------");
        System.out.println("---------------------arr1-Number-arr2-Number--------------------------");
        System.out.println(compareArrays(arr1, arr2));
        System.out.println("---------------------arr2-Number-arr3-Number--------------------------");
        System.out.println(compareArrays(arr2, arr3));
        System.out.println("---------------------arr3-Number-arr4-String--------------------------");
        System.out.println(compareArrays(arr3, arr4));
        System.out.println("---------------------arr4-String-arr5-String--------------------------");
        System.out.println(compareArrays(arr4, arr5));


        System.out.println("------------------------compareArraysByNumber-----------------------");
        System.out.println("--------------------arr1-Number-arr2-Number--------------------------");
        System.out.println(compareArraysByNumber(arr1, arr2));
        System.out.println("--------------------arr2-Number-arr3-Number--------------------------");
        System.out.println(compareArraysByNumber(arr2, arr3));
        System.out.println("--------------------arr3-Number-arr4-String--------------------------");
        System.out.println(compareArraysByNumber(arr3, arr4));
        System.out.println("--------------------arr4-String-arr5-String--------------------------");
        System.out.println(compareArraysByNumber(arr4, arr5));


    }
}

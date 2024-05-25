package org.example.DZ3.Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * ArrayComparator имеет метод
 * compareArrays для сравнения двух массивов и проверки на супер класс
 */
public class ArrayComparator2 {

    public static ArrayList<A> arrayListA;
    public static ArrayList<A> arrayListA2;
    public static ArrayList<B> arrayListB;
    public static ArrayList<C> arrayListC;

    public static <T1, T2> boolean compareArrays(ArrayList<T1> a, ArrayList<T2> b) {
        if (a.size() != b.size()) {
            return false;
        }

        for (int i = 0; i < a.size(); i++) {
            if (!isSubtype(a.get(i).getClass(), b.get(i).getClass())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSubtype(Class<?> subclass, Class<?> superclass) {
        return superclass.isAssignableFrom(subclass);
    }

    public static void main(String[] args) {
        arrayListA = new ArrayList<>();
        arrayListA2 = new ArrayList<>();
        arrayListB = new ArrayList<>();
        arrayListC = new ArrayList<>();

        A a = new A();
        B b = new B();
        C c = new C();

        A[] arr1 = new A[5];
        B[] arr2 = new B[5];
        C[] arr3 = new C[5];

        Arrays.fill(arr1,a);
        Arrays.fill(arr2,b);
        Arrays.fill(arr3,c);

        Collections.addAll(arrayListA, arr1);
        Collections.addAll(arrayListA2, arr1);
        Collections.addAll(arrayListB, arr2);
        Collections.addAll(arrayListC, arr3);

        System.out.println("------------------------compareArrays-----------------------");
        System.out.println(compareArrays(arrayListA, arrayListB)); // false
        System.out.println(compareArrays(arrayListA, arrayListA2)); // true
        System.out.println(compareArrays(arrayListC, arrayListB)); // true
    }
}

class A {

}

class B {

}

class C extends B {

}

package org.example.DZ3.Task2;

import java.util.ArrayList;
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

        Collections.addAll(arrayListA, a, a, a, a, a);
        Collections.addAll(arrayListA2, a, a, a, a, a);
        Collections.addAll(arrayListB, b, b, b, b, b);
        Collections.addAll(arrayListC, c, c, c, c, c);

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

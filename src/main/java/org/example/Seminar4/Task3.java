package org.example.Seminar4;

import java.util.*;

/**
 * В рамках выполнения задачи необходимо:
 *     1. Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
 *     2. Найдите человека с самым маленьким номером телефона
 *     3. Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */

public class Task3 {


    public static void main(String[] args) {
        HashMap<String,String> phoneBook = new HashMap<>();

        phoneBook.put("87123111","Ivanov");
        phoneBook.put("87123222","Petrov");
        phoneBook.put("87123333","Sidorov");
        phoneBook.put("87123444","Sidorov2");
        phoneBook.put("87123555","Sidorov3");

//        System.out.println(phoneBook);

        System.out.println(getLittleNumber(phoneBook));
    }


    public static String getLittleNumber(HashMap<String,String> map) {
        Set<String> set = map.keySet();
        Integer[] objects = new Integer[set.size()];
        int i = 0;
        for (String object : set) {
            objects[i++] = Integer.parseInt(object);
        }
        List<Integer> list = Arrays.asList(objects);
        return Collections.min(list).toString();
    }





}

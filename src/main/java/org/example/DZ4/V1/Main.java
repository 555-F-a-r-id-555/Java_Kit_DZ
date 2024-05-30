package org.example.DZ4.V1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Задание 1. Создать справочник сотрудников
 * Необходимо:
 * ● Создать класс справочник сотрудников, который
 * содержит внутри коллекцию сотрудников - каждый
 * сотрудник должен иметь следующие атрибуты:
 * ○ Табельный номер
 * ○ Номер телефона
 * ○ Имя
 * ○ Стаж
 * ● Добавить метод, который ищет сотрудника по стажу
 * (может быть список)
 * ● Добавить метод, который выводит номер телефона
 * сотрудника по имени (может быть список)
 * ● Добавить метод, который ищет сотрудника по
 * табельному номеру
 * ● Добавить метод добавление нового сотрудника в
 * справочник
 */

public class Main {


    public static void main(String[] args) {

        List<Employee> employees = createEmployee();
//        System.out.println(findEmployeesByExp(employees, 5));
        System.out.println(findEmployeesByPhoneNumber(employees,"Masha"));
//        System.out.println(findEmployeesByPersonnelNumber(employees,1));
//        System.out.println(employees);
//        System.out.println(addEmployee(employees,new Employee(1,"1111","Dasha",4)));

    }

    public static List<Employee> createEmployee() {
        Employee employee1 = new Employee(1, "811115", "Petya", 1);
        Employee employee2 = new Employee(2, "812345", "Sasha", 9);
        Employee employee3 = new Employee(3, "811115", "Vasya", 5);
        Employee employee4 = new Employee(8, "811155", "Kolya", 2);
        Employee employee5 = new Employee(10, "811145", "Masha", 5);
        Employee employee6 = new Employee(10, "855555", "Masha", 5);

        List<Employee> employees = new ArrayList<>();

        Collections.addAll(employees, employee1, employee2, employee3, employee4, employee5,employee6);

        return employees;
    }

    public static List<Employee> findEmployeesByExp(List<Employee> employees, int exp) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == exp) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    public static List<String> findEmployeesByPhoneNumber(List<Employee> employees, String Name) {
        List<String> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(Name)) {
                list.add(employee.getPhoneNumber());
            }
        }
        return list;
    }


    public static List<Employee> findEmployeesByPersonnelNumber(List<Employee> employees, int personnelNumber) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getPersonnelNumber() == personnelNumber) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    public static List<Employee> addEmployee(List<Employee> employees, Employee employee) {
        employees.add(employee);
        return employees;
    }

}


package org.example.DZ4.V2;

import java.util.List;

public class Employee2 {

    List<Employee2> employees;
    private final Integer PersonnelNumber;
    private final String PhoneNumber;
    private final String Name;
    private Integer Experience;




    public Employee2(Integer personnelNumber, String phoneNumber, String name, Integer experience) {
        PersonnelNumber = personnelNumber;
        PhoneNumber = phoneNumber;
        Name = name;
        Experience = experience;
    }


    public List<Employee2> getEmployees() {
        return employees;
    }

    public Integer getPersonnelNumber() {
        return PersonnelNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getName() {
        return Name;
    }

    public Integer getExperience() {
        return Experience;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                ", PersonnelNumber=" + PersonnelNumber +
                ",\n PhoneNumber='" + PhoneNumber + '\'' +
                ",\n Name='" + Name + '\'' +
                ",\n Experience=" + Experience +
                "}\n";
    }
}


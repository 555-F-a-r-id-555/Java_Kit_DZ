package org.example.DZ4.V2;

import java.util.ArrayList;
import java.util.List;

public class EmployeesActions implements EmployeeView {
    @Override
    public List<Employee2> employeeActions(List<Employee2> employees, EmployeeCriterion criterion) {
        List<Employee2> employeeList = new ArrayList<>();
        for (Employee2 employee : employees) {
            if (criterion.test(employee)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

}

package org.example.DZ4.V2;

import java.util.List;

public interface EmployeeView {
    List<Employee2> employeeActions(List<Employee2> employees, EmployeeCriterion criterion);
}

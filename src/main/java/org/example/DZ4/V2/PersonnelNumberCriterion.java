package org.example.DZ4.V2;

class PersonnelNumberCriterion implements EmployeeCriterion {
    private final Integer personnelNumber;

    public PersonnelNumberCriterion(Integer personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    @Override
    public boolean test(Employee2 employee) {
        return employee.getPersonnelNumber().equals(personnelNumber);
    }
}
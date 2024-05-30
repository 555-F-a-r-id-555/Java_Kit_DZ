package org.example.DZ4.V2;

public class PhoneNumberCriterion implements EmployeeCriterion {
    private final String phoneNumber;

    public PhoneNumberCriterion(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean test(Employee2 employee) {
        return employee.getPhoneNumber().equals(phoneNumber);
    }
}

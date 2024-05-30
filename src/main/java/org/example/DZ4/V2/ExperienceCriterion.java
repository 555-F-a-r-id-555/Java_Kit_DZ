package org.example.DZ4.V2;

public class ExperienceCriterion implements EmployeeCriterion {
    protected final int experience;

    public ExperienceCriterion(int experience) {
        this.experience = experience;
    }

    @Override
    public boolean test(Employee2 employee) {
        return employee.getExperience().equals(experience);
    }

}
package com.codecafe.NestedClasses.domain;

import java.util.Comparator;

public class EmployeeComparator<T extends Employee> implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2){
        return o1.getName().compareTo(o2.getName());
        //return o1.getEmployeeId().compareTo(o2.getEmployeeId());

        // Notes : Years Started Field is private to the employee class. So within this class, we are
        //unable to access that Years Started Field. So we are adding this class inside employee class.
    }
}

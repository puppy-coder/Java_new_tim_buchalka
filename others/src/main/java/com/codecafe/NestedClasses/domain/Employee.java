package com.codecafe.NestedClasses.domain;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Comparator;

// Static Nested Class Experiment
public class Employee {

    // Static nested class
    // To create a static class, you add a class as part of another class's body(Employee),
    // making it static. This lets you access it via the class name, like other static variables. But
    // this nested static class has access to all the outer classes private members and vice versa.

    // Important : Using a nested class for this comparator, I was able to keep my attributes
    //encapsulated, without needing to provide getter methods for each one
    public static class EmployeeComparator<T extends Employee> implements Comparator<Employee> {

        private String sortType;

        public EmployeeComparator(){
            this("name"); // calls another constructor (Employee Comparator) within the same class
        }
        public EmployeeComparator(String sortType){
            this.sortType = sortType;
        }
        @Override
        public int compare(Employee o1, Employee o2) {
            //return o1.getName().compareTo(o2.getName()); // Here, simply use name instead of get name

            if(sortType.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted; // Now Year started is available. Because nested class
                // has an advantage of accessing outer class private fields
            }
            return o1.name.compareTo(o2.name);
        }
    }

    private int employeeId;

    private String name;

    private int yearStarted;

    public Employee(){

    }

    public Employee(int employeeId, String name, int yearStarted){
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;

    }

    public String getName(){
        return name;
    }

    public int getEmployeeId(){
        return employeeId;
    }

    @Override
    public String toString(){
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }
}

package com.codecafe.NestedClasses.domain;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Comparator;

public class Employee {

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

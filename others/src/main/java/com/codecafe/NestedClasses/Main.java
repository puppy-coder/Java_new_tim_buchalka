package com.codecafe.NestedClasses;

import com.codecafe.NestedClasses.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane", 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Jim", 2018)
        ));

        // New Separate Class :
        // var comparator = new EmployeeComparator<>();
        //employeeList.sort(comparator);

        //Static Nested Class :
        // We can access the static nested class using the Outer class name just like static variables.
        //here, we simply instantiate the comparator, with new Employee.EmployeeComparator with diamond operator.
        employeeList.sort(new Employee.EmployeeComparator<>("yearStarted")); // Here, diamond operator is empty
        //because Java can infer its type.
        //employeeList.sort(new Employee.EmployeeComparator<>());
        // Comparator interface has a default method called reversed.
        //The Reverse method will reverse the sort for any comparator
        //employeeList.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

        for(Employee e : employeeList){
            System.out.println(e);
        }

    }
}

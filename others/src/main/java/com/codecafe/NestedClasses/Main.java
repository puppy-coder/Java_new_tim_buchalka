package com.codecafe.NestedClasses;

import com.codecafe.NestedClasses.domain.Employee;
import com.codecafe.NestedClasses.domain.StoreEmployee;
import com.codecafe.innerclass.BillsBurger.Challenge.Store;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Static nested class access example
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

        // Inner class access example
        System.out.println("Store Members");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019, "Target" ),
                new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10105, "Tom", 2020, "Macys"),
                new StoreEmployee(10215, "Marty", 2018, "Walmart"),
                new StoreEmployee(10322, "Bud", 2016, "Target"))
        );

        // Its sorts the store members by the default sort for that comparator, which is name.
        // But in this code, I'm not using the store comparator, I created on storeEmployee.
        // Instead, I'm using the static EmployeeComparator on Employee, and you can see that, I have
        // accessed the comparator on Employee through the StoreEmployee class. This means that
        // static nested classes are inherited by subclasses.
        var comparator = new StoreEmployee.EmployeeComparator<>();
        storeEmployees.sort(comparator);

        // But I really want an instance of StoreEmployee's own comparator class, an inner class,
        // which I called StoreComparator

        //var comparator1 = new StoreEmployee.StoreComparator<>(); // Error : StoreEmployee is not an
        // enclosing class. That's because an inner class requires an instance of the enclosing class
        // to be used, in order to instantiate the inner class. Here, I am really calling the class
        // StoreEmployee, but not an actual instance of the StoreEmployee class, so it doesn't work.

        var genericEmployee = new StoreEmployee();
        var comparator1 =  genericEmployee.new StoreComparator<>();
        storeEmployees.sort(comparator1); // This is how we access the inner class

        // Without local variable "genericEmployee" , we can use chain of instantiation
        var comparator2 = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator2);
        // The dot new isn't calling a method, but rather it is creating an instance of an inner
        // class , which I have declared on Store Employee

        for(StoreEmployee e : storeEmployees){
            System.out.println(e);
        }

    }
}

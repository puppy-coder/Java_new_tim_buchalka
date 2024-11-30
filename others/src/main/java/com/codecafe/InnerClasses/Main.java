package com.codecafe.InnerClasses;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Store Members");
        List<StoreEmployee> storeEmployeeList = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10105, "Tom", 2020, "Macys"),
                new StoreEmployee(10215, "Marty", 2018, "Walmart"),
                new StoreEmployee(10315, "Bud", 2016, "Target")
        ));
        //Important : Here I am not using the StoreComparator, I created on StoreEmployee.
        //Instead, I'm using the static EmployeeComparator on Employee.
        //This means, I have accessed the comparator on Employee through the Store Employee class.
        //This means, static nested classes are inherited by subclasses
        //var comparator = new StoreEmployee.EmployeeComparator<>();
        //storeEmployeeList.sort(comparator);

        // Error : InnerClasses.StoreEmployee is not an enclosing class.This is because an inner class requires
        // an instance of the enclosing class to be used, in order to instantiate an inner class
        //var comparator1 = new StoreEmployee.StoreComparator<>();

        var genericEmployee = new StoreEmployee();
        // Its a special syntax to instantiate store comparator
        var comparator1 = genericEmployee.new StoreComparator<>();
        storeEmployeeList.sort(comparator1);

        // Here, we don't want to use genericEmployee Local variable. Instead, chain the instantiations.
        var comparator2 = new StoreEmployee().new StoreComparator<>(); // Chain method
        storeEmployeeList.sort(comparator1);


        for(StoreEmployee e : storeEmployeeList){
            System.out.println(e);
        }
    }
}

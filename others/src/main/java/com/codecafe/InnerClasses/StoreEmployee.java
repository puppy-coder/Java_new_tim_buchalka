package com.codecafe.InnerClasses;

import java.util.Comparator;

public class StoreEmployee extends Employee{

    private String store;

    //To access this comparator from the calling code
    public StoreEmployee(){

    }
    public StoreEmployee(int employeeId, String name, int yearStarted, String store){
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    @Override
    public String toString(){
        return "%-8s%s".formatted(store, super.toString());
    }
    public class StoreComparator<T extends StoreEmployee> implements Comparator<StoreEmployee>{

        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2){
            int result = o1.store.compareTo(o2.store);
            if(result == 0){
                return new Employee.EmployeeComparator<>("yearStarted").compare(o1,o2);
            }
            return result; // If the result is 0, that means the employees work at the same store
        }
    }

}

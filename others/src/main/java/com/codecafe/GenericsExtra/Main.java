package com.codecafe.GenericsExtra;

import com.codecafe.GenericsExtra.util.QueryItem;
import com.codecafe.GenericsExtra.util.QueryList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

record Employee(String name) implements QueryItem {
    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new lPAStudent());
        //printList(students);
        printLists(students);

        List<lPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new lPAStudent());
        }
        //printList(lpaStudents);
        printLists(lpaStudents);

        //type erasure solution
        testList(new ArrayList<String>(List.of("Tim", "Abdul", "Dhana")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3)));

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("Course", "Python");
        printLists(matches);

        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
        printLists(students2021);

        //var students2021_1 = QueryList.getMatches(new ArrayList<>(), "YearStarted", "2021");
        //printLists(students2021_1); // Error Line : List<QueryItem> not compatible with
        // List<? extends Student>

        // Solution for the above compatible error:
        var students2021_1 = QueryList.<Student>getMatches(new ArrayList<>(), "YearStarted", "2021");
        printLists(students2021_1); // This is fine but contrived example

        //QueryList<Employee> queryList1 = new QueryList<Employee>();
        //Error here: the above line shows: Employee is not within its bound, should extend student

    }

    public static <T extends Student> void printLists(List<? extends Student> students) {
        for (var student : students) {
            System.out.println(student.getYearStarted() + ":" + student);
            System.out.println(student);
        }
        System.out.println();
    }

    //Wildcard -> Question mark alone
    public static <T extends Student> void printMoreLists_1(List<?> students) {
        for (var student : students) {
            //Gives error because using Student method is not possible here
            //Error Line :
            //System.out.println(student.getYearStarted() + ":" + student);
            System.out.println(student);
        }
        System.out.println();
    }

    // Wildcard -> Question mark with lower bound
    // public static <T extends Student> void printMoreLists(List<? super Student> students) {
    //for (var student : students) {
    //Gives error because using Student method is not possible here,
    // super means parent class of student. i.e., object here!
    //Error Line : System.out.println(student.getYearStarted() + ":" + student);
    // System.out.println(student);
    //}
    //System.out.println();
    // }

    // Wildcard -> Question mark with upper bound
    public static <T extends Student> void printMoreLists_3(List<? extends Student> students) {

        Student last = students.get(students.size() - 1);
//            students.set(0, last);// Shows error: This method with wildcards has no way of knowing
        // the type of the list elements that is getting passed to it.
        // They are unknown.It could be one of many types, sub classed from student.
//            In other words, the compiler doesn't have enough information to enforce the type checking rules
//             It knows there are rules, because we are using type arguments.
//            But it can't safely say if this list is a list of Students, a list of lpastudents or a mix.
//             so it won't let you add an element
//             Wildcard capture is the ability of the compiler to infer the correct type parameter and here
//             it can't do it.

        for (var student : students) {
            // Won't give any error because extends means subClass or student itself.
            System.out.println(student.getYearStarted() + ":" + student);
            System.out.println(student);
        }
        System.out.println();
    }

//    public static <T extends Student> void printList(List<T> students){
//        for(var student : students){
//            System.out.println(student.getYearStarted() + ":" + student);
//        }
//        System.out.println();
//    }

    public static void testList(List<?> list) {
        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

    // Type Erasure example: "Important"

//    public static void testList(List<String> list){
//        for(var element : list){
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }

//    public static void testList(List<Integer> list){
//        for(var element : list){
//            System.out.println("Integer: " + element.floatValue());
//        }
//    }

    // Wildcard usage
    //Method parameter and return type declaration usage of wildcard
    public static <E> List<? extends E> merge(List<? extends E> list1, List<? extends E> list2) {
        return Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
    }

    public static <E> List<E> merge2(List<? extends E> list1, List<? extends E> list2) {
        return Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
    }

    public static void test() {
        //Local variable declaration wildcard usage
        List<? extends Number> merged = merge(List.of(1, 2, 3), List.of(4, 5, 6));

        List<Number> merged2 = merge2(List.of(1, 2, 3), List.of(4, 5, 6));
    }
}


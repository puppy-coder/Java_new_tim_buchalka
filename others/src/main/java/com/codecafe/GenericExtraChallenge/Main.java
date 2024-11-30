package com.codecafe.GenericExtraChallenge;


import com.codecafe.GenericExtraChallenge.util.QueryList;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        QueryList<lPAStudent> queryList = new QueryList<>();
        for(int i = 0; i <=25; i ++){
            queryList.add(new lPAStudent());
        }
        System.out.println("Ordered");
        // Showing error because comparator interface is not implemented by Student
       // queryList.sort(Comparator.naturalOrder());

        // Now error gone, because student implements comparable interface
        // Big Doubt
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println("Matches");
        var matches = queryList.getMatches("percentComplete", "50")
                .getMatches("Course", "Python");
        matches.sort(new LPAStudentComparator());
        printList(matches);

        System.out.println("Ordered");
        matches.sort(null);
        printList(matches);


    }

    public static void printList(List<?> students){
        for(var student : students)
            System.out.println(student);
    }
}

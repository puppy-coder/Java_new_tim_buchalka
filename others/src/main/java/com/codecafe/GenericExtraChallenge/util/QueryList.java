package com.codecafe.GenericExtraChallenge.util;


import com.codecafe.GenericExtraChallenge.Student;

import java.util.ArrayList;
import java.util.List;

// Multiple Upper bound

// This class has all the functionality of an ArrayList, but includes functionality to search
// the data by field values
public class QueryList<T extends Student & QueryItem> extends ArrayList<T> {

    public QueryList(){

    }

    public QueryList(List<T> items){
        super(items);
    }

    public static <S extends QueryItem> List<S> getMatches(List<S> items, String field, String value){
        List<S> matches  = new ArrayList<>();
        for(var item : items){
            if(item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }

    public QueryList<T> getMatches(String field, String value){
        QueryList<T> matches  = new QueryList<>();
        for(var item : this){
            if(item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }
}

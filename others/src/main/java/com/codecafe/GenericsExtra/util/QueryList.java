package com.codecafe.GenericsExtra.util;

import com.codecafe.GenericsExtra.Student;

import java.util.ArrayList;
import java.util.List;

// Multiple Upper bound
public class QueryList<T extends Student & QueryItem> {

    private List<T> items;

    public QueryList(List<T> items){
        this.items = items;
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

    public List<T> getMatches(String field, String value){
        List<T> matches  = new ArrayList<>();
        for(var item : items){
            if(item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }
}

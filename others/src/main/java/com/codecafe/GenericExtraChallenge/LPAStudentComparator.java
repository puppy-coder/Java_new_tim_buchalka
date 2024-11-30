package com.codecafe.GenericExtraChallenge;

import java.util.Comparator;

public class LPAStudentComparator implements Comparator<lPAStudent> {
    @Override
    public int compare(lPAStudent o1, lPAStudent o2) {
        return (int) (o1.getPercentComplete() - o2.getPercentComplete());
    }
}

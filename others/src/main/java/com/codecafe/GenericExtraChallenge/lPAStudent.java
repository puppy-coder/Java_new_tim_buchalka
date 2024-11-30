package com.codecafe.GenericExtraChallenge;

public class lPAStudent extends Student {

    private double percentComplete;

    public lPAStudent(){
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString(){
        // Note : %% after 8.1 indicates that thw output will be in percentage sign
        return "%s %8.1f%%". formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete(){
        return  percentComplete;
    }

    @Override
    public boolean matchFieldValue (String fieldName, String value){
        if(fieldName.equalsIgnoreCase("percentComplete")){
            return percentComplete <= Integer.parseInt(value);
        }
        return super.matchFieldValue(fieldName, value);
    }

}

package com.codecafe.EncapsulationChallenge;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex){
        this.pagesPrinted = 0;
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount){
        int tempAmount = tonerAmount + tonerLevel;
        if(tempAmount > 100 || tempAmount < 0){
            return -1;
        }
        tonerLevel = tonerAmount + tonerLevel;
        return tonerAmount;
    }

    public int printPages(int pages){
        /*Logic - Two pages will get printed on 1 sheet of paper but 3 pages will need 2 sheets
         of paper. This means the calculation we need doesn't just divide the number of printed
         pages by 2, but we need to add a additional page, if it's an odd number.
         The result of the modulo operation will only ever be a 0 or 1.
         This means when it's an odd number of pages, an extra sheet of paper is included.
          */
        int jobPages = (duplex) ? (pages/2) + (pages % 2) : pages;
        pagesPrinted = pagesPrinted + jobPages;
        return jobPages;

    }

    public int getPagesPrinted(){
        return pagesPrinted;
    }
}

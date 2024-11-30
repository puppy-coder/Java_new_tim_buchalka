package com.codecafe.Composition;

public class PersonalComputer extends Product { // Personal Computer - Downstream
    private ComputerCase computerCase; // Upstream
    private Monitor monitor; // Upstream
    private Motherboard motherboard; // Upstream

    public PersonalComputer(String model, String manufacturer, ComputerCase computerCase, Monitor monitor, Motherboard motherboard) {
        super(model, manufacturer);
        this.computerCase = computerCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    //Method 1 - Using getters to access the functions

//    public ComputerCase getComputerCase() {
//        return computerCase;
//    }
//
//    public Monitor getMonitor() {
//        return monitor;
//    }
//
//    public Motherboard getMotherboard() {
//        return motherboard;
//    }

    //Method 2 - Create private method

     private void drawLogo(){
        monitor.drawPixelAt(1200, 50, "yellow");
     }
     public void powerUp(){
        computerCase.pressPowerButton();
        drawLogo();
     }

}

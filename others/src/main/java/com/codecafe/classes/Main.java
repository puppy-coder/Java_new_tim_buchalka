package com.codecafe.classes;



public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setMake("Maserati");
        car.setColor("Red");
        car.setConvertible(true);
        car.setDoors(2);
        car.setModel("XLX");
        System.out.println(car.getMake());
        car.describeCar();
    }
}
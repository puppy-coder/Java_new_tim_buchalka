package com.codecafe.GenericsChallenge;

public class Main {
    public static void main(String[] args) {

        var nationalUSParks = new Park[]{
                new Park("Yellowstone", "44.4882, -110.5916"),
                new Park("Grand Canyon", "36.1085, -112.0965"),
                new Park("Yosemite", "37.8855, -119.5360")
        };

        Layer<Park> parkLayer = new Layer<>(nationalUSParks);
        parkLayer.renderLayer();

        var majorUSRivers = new River[]{
                new River("Mississippi", "47.2160, -95.2348",
                        "35.1556, -90.065", "29.1566, -89.2495"),
                new River("Missouri", "45.9239, -111.4983", "38.8146, -90.1218" )
        };

        Layer<River> riverLayer = new Layer<>(majorUSRivers);
        riverLayer.addElements(new River("Colorado", "40.4708, -105.8286",
                "31.7811, -114.7724"),
                new River("Delware", "42.2026, -75.00836", "39.4955, -75.5592"));

        riverLayer.renderLayer();

        //Our layer generic class never had any knowledge about the point or line class or the
        //Park or River classes, but able to make use of the Mappable class as it's type parameter to
        // support a container for these classes.
    }
}

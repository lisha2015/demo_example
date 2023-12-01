package com.pattern.stratagy2;

public class Client {

    public static void main(String[] args) {

        TravelContext context = new TravelContext(new Plane());
        context.travelWay();

        context = new TravelContext(new Rail());
        context.travelWay();

    }
}

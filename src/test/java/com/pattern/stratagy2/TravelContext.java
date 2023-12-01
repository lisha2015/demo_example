package com.pattern.stratagy2;

public class TravelContext {

    private Stratagy stratagy;

    public TravelContext(Stratagy stratagy) {
        this.stratagy = stratagy;
    }

    public void travelWay(){
        stratagy.execute();
    }
}

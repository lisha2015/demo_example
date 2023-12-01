package com.pattern.stratagy;

public class Context {
    private Stratagy stratagy;

    public void setStratagy(Stratagy stratagy) {
        this.stratagy = stratagy;
    }

    public void operation(){
        stratagy.execute();
    }
}

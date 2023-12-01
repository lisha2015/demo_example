package com.pattern.stratagy1;

public class StratagyContext {
    private Stratagy stratagy;

    public void setStratagy(Stratagy stratagy) {
        this.stratagy = stratagy;
    }

    public void operation(){
        stratagy.execute();
    }
}

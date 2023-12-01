package com.pattern.template2;

public abstract class Draw {

    abstract void step1();
    abstract void step2();
    abstract void step3();

    final void execute(){
        step1();
        step2();
        step3();
    }

}

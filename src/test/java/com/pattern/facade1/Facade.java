package com.pattern.facade1;

public class Facade {
    private SubSystem1 system1;
    private SubSystem2 system2;

    public Facade() {
        system1 = new SubSystem1();
        system2 = new SubSystem2();
    }

    public void start(){
        system1.start();
        system2.start();
    }
}

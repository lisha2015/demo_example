package com.pattern.facade;

public class StartButton {

    private CPU cpu;
    private HardWare hardWare;
    private Screen screen;

    public StartButton() {
        cpu = new CPU();
        hardWare = new HardWare();
        screen = new Screen();
    }

    public void start(){
        cpu.operation();
        hardWare.operation();
        screen.operation();
    }

}

package com.pattern.command1;

public class TurnOn implements Command{

    public Light light = new Light();

    @Override
    public void execute() {
        System.out.println("打开命令");
        light.on();
    }
}

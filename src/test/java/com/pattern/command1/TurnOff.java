package com.pattern.command1;

public class TurnOff implements Command{
    public Light light;
    @Override
    public void execute() {
        System.out.println("关闭命令");
        light.off();
    }
}

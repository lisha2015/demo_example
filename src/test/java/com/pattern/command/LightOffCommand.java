package com.pattern.command;

public class LightOffCommand implements Command{

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {

        light.turnOff();
    }

    @Override
    public void undo() {
        System.out.println("撤销了关灯操作");
    }
}

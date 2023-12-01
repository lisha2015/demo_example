package com.pattern.Command2;

public class TurnOnCommand implements Command{
    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("输入了打开指令");
        light.on();
    }
}

package com.pattern.Command2;

public class TurnOffCommand implements Command{
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("输入了关闭指令");
        light.off();
    }
}

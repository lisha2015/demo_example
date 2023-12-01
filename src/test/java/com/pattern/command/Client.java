package com.pattern.command;

public class Client {


    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand onCommand= new LightOnCommand(light);
        LightOffCommand offCommand = new LightOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(onCommand);

        remoteControl.pressButton();

        remoteControl.setCommand(offCommand);
        remoteControl.pressButton();

        remoteControl.pressUndoButton();


    }
}

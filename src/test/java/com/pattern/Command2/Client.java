package com.pattern.Command2;

public class Client {

    public static void main(String[] args) {
        HumanOperation operation = new HumanOperation();
        operation.setCommand(new TurnOnCommand(new Light()));
        operation.pressButton();
    }
}

package com.pattern.command1;

public class Client {

    public static void main(String[] args) {
        Human human = new Human();
        human.setCommand(new TurnOn());
        human.pressButton();
    }
}

package com.pattern.mediator1;

public interface Mediator {

    void sendMessage(Colleague colleague, String message);

    void receiveMessage(Colleague colleague, String message);

}

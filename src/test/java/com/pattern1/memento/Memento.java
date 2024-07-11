package com.pattern1.memento;

/**
 * Memento（备忘录）类，用于存储Originator的状态
 */
public class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

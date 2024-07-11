package com.pattern1.memento;

/**
 * Caretaker（负责人）类，负责保存和恢复Originator的状态
 */
public class Caretaker {
    private Memento memento;

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }
}

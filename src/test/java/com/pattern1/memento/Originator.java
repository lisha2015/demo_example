package com.pattern1.memento;

/**
 * 备忘录
 * Originator（发起人）类，需要保存状态的对象
 */
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    // 创建备忘录对象，并将当前状态保存到备忘录中
    public Memento createMemento() {
        return new Memento(state);
    }

    // 从备忘录中恢复之前保存的状态
    public void restoreFromMemento(Memento memento) {
        state = memento.getState();
    }
}

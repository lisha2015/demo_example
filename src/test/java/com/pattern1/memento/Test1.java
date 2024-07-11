package com.pattern1.memento;

public class Test1 {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // 设置初始状态并保存到备忘录
        originator.setState("State 1");
        caretaker.setMemento(originator.createMemento());

        // 修改状态
        originator.setState("State 2");

        // 恢复到之前保存的状态
        originator.restoreFromMemento(caretaker.getMemento());

        System.out.println(originator.getState()); // 输出: State 1
    }
}

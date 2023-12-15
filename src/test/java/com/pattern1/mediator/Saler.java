package com.pattern1.mediator;

public class Saler {
    String NO;
    String name;
    Mediator me;

    public Saler(String NO, String name, Mediator me) {
        this.NO = NO;
        this.name = name;
        this.me = me;
    }

    public String getNO() {
        return NO;
    }

    public String getName() {
        return name;
    }

    void receive(String msg) {

        System.out.println(NO+"\t" + name+"receive:");
        System.out.println("\t" + msg);
    }

    void send(String msg) {
        me.send(this, msg);

    }
}

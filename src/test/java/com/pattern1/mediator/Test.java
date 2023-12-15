package com.pattern1.mediator;

public class Test {
    public static void main(String[] args) {
        Mediator me = new Mediator();
        Renter r = new Renter("1000", "li", me);
        Saler s = new Saler("2000", "sun", me);
        Saler s2 = new Saler("2001", "sun2", me);

        me.addRenter(r);
        me.addSaler(s);
        me.addSaler(s2);

        r.send("i want rent a house");
        s.send("i want to sale a house");

    }
}

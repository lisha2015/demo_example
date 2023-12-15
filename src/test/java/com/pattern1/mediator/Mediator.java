package com.pattern1.mediator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Mediator {
    Map<String, Renter> m = new HashMap<>();
    Map<String, Saler> m2 = new HashMap<>();

    void addRenter(Renter renter) {
        m.put(renter.getNO(), renter);
    }

    void addSaler(Saler s) {
        m2.put(s.getNO(), s);
    }

    public void send(Renter r, String msg) {
        System.out.println("come form renter=" + r.getNO()+"-"+r.getName());
        System.out.println("\t" + msg);
        Set<String> se = m2.keySet();
        Iterator<String> it = se.iterator();
        while (it.hasNext()){
            String key = it.next();
            Saler sa = m2.get(key);
            sa.receive(r.getNO()+"-" + r.getName()+"-" + msg);
        }
    }

    public void send(Saler s, String msg) {
        System.out.println("come from saler-"+s.getNO() + "-" + s.getName());
        System.out.println("\t" + msg);
        Set<String> se = m.keySet();
        Iterator<String> it = se.iterator();
        while (it.hasNext()){
            String key = it.next();
            Renter r = m.get(key);
            r.receive(s.getNO() + "-" + s.getName() + "-" + msg);
        }
    }
}

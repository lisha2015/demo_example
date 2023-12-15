package com.pattern1.mediator;

/**
 * 仍以房屋中介功能为例，实现的功能是：
 * ①租房者发布租房信息至房屋中介，房屋中介将收到的信息发布给所有出租房屋者；
 * ②出租房屋者发布信息至房屋中介，房屋中介将收到的信息发布给所有租房者。
 * 编制的功能类如下所示。
 */
// 租房者对象
public class Renter {
    String NO;
    String name;
    Mediator me;

    public Renter(String NO, String name, Mediator me) {
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
        System.out.println(NO + "\t" + name + "receive:");
        System.out.println("\t" + msg);
    }

    void send(String msg) {
        me.send(this, msg);
    }
}

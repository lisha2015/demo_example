package com.pattern.decorate3;

public class ChocolateDecorater extends IceDecorator{

    public ChocolateDecorater(IceCream cream) {
        super(cream);
    }

    @Override
    public void makeCreame() {
        System.out.println("加巧克力");
        cream.makeCreame();
        System.out.println("巧克力冰激凌");
    }
}

package com.pattern.decorate3;

public class MilkDecorater extends IceDecorator{

    public MilkDecorater(IceCream cream) {
        super(cream);
    }

    @Override
    public void makeCreame() {
        System.out.println("加牛奶");
        cream.makeCreame();
        System.out.println("牛奶冰激凌");
    }
}

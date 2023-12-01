package com.pattern.decorate2;

public class MilkDecorate extends CafeDecorate {

    public MilkDecorate(Cafe cafe) {
        super(cafe);
    }

    @Override
    public void makeCafe() {
        System.out.println("加点牛奶");
        super.makeCafe();
        System.out.println("制作牛奶咖啡");
    }


}

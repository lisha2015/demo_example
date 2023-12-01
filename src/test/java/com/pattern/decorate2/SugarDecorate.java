package com.pattern.decorate2;

public class SugarDecorate extends CafeDecorate {

    public SugarDecorate(Cafe cafe) {
        super(cafe);
    }

    @Override
    public void makeCafe() {
        System.out.println("加点糖");
        super.makeCafe();
        System.out.println("制作甜味咖啡");
    }


}

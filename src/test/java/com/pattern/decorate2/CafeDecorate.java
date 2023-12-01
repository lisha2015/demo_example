package com.pattern.decorate2;

public abstract class CafeDecorate implements Cafe{
    private Cafe cafeDecorate;

    public CafeDecorate(Cafe cafe) {
        this.cafeDecorate = cafe;
    }

    @Override
    public void makeCafe() {
        cafeDecorate.makeCafe();
    }
}

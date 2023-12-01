package com.pattern.decorate3;

public  abstract class IceDecorator implements IceCream{

    protected IceCream cream;

    public IceDecorator(IceCream cream) {
        this.cream = cream;
    }

    @Override
    public void makeCreame() {
        cream.makeCreame();
    }
}

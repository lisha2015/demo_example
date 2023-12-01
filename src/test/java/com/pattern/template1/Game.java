package com.pattern.template1;

/**
  * @desc
  * @author 2023/11/28 0028 10:08 lisha
  */
public abstract class Game {

    protected abstract void start();

    abstract void play();

    abstract void exit();

    public final void operation() {
        start();
        play();
        exit();
    }


}

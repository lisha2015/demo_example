package com.pattern.template;

public abstract class Template{

        abstract void start();

        abstract void play();

        abstract void exit();

        public final void operation(){
            start();
            play();
            exit();
        }

}

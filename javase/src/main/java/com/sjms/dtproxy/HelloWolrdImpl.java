package com.sjms.dtproxy;

public class HelloWolrdImpl implements IHelloWorld{

    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }

    @Override
    public void sayFuckYou() {
        System.out.println("fuck you bitch!");
    }
}

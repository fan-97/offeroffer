package com.sjms.abstrctFactory;

public class Product1 implements IProduct {

    public Product1(){
        this.info();
    }
    @Override
    public void info() {
        System.out.println("这是第一个产品");
    }
}

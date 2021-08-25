package com.sjms.abstrctFactory;

public class Product2 implements  IProduct {

    public Product2(){
        this.info();
    }

    @Override
    public void info() {
        System.out.println("这是第二个产品");
    }
}

package com.sjms.abstrctFactory;

public class Factory1 implements IFactory {
    @Override
    public IProduct createProduct(String productNo) {
        return new Product1();
    }
}

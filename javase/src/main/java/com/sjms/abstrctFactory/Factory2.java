package com.sjms.abstrctFactory;

public class Factory2 implements IFactory {
    @Override
    public IProduct createProduct(String productNo) {
        return new Product2();
    }
}

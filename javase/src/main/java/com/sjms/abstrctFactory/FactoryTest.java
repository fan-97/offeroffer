package com.sjms.abstrctFactory;

public class FactoryTest {
    public static void main(String[] args) {
        IFactory factory = new PublicFactory();
        factory.createProduct("product1");
        factory.createProduct("product2");
    }
}

package com.sjms.abstrctFactory;

public class PublicFactory implements IFactory {

    private IFactory factory= null;

    @Override
    public IProduct createProduct(String productNo) {

        if("product1".equals(productNo)){
            factory = new Factory1();
        }else if("product2".equals(productNo)){
            factory = new Factory2();
        }

        if(factory!=null){
            return factory.createProduct(productNo);
        }

        return null;
    }

}

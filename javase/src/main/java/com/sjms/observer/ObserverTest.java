package com.sjms.observer;

public class ObserverTest {
    public static void main(String[] args) {
        ProductList productList = ProductList.getInstance();

        //添加观察者
        JingDongObserver jingDongObserver = new JingDongObserver();
        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        productList.addProductListObserver(jingDongObserver);
        productList.addProductListObserver(taoBaoObserver);
        productList.addProduct("产品2");
    }
}

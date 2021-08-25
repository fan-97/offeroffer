package com.sjms.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {

    private List<String> productList = null;//产品列表

    private static ProductList instance = null;

    private ProductList(){}

    public static ProductList getInstance(){
        if(instance ==null){
            instance= new ProductList();
            instance.productList = new ArrayList<>();
        }
        return instance;
    }

    public void addProductListObserver(Observer observer){
        this.addObserver(observer);
    }

    public void addProduct(String newProduct){
        productList.add(newProduct);
        System.out.println("产品新增了  "+newProduct);
        //设置被观察对象发生变化
        this.setChanged();
        //通知观察着并传递新产品
        this.notifyObservers(newProduct);
    }

}

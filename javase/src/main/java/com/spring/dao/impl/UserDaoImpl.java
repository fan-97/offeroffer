package com.spring.dao.impl;

import com.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {
    private String name;
    public UserDaoImpl(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDaoImpl{" +
                "name='" + name + '\'' +
                '}';
    }
}

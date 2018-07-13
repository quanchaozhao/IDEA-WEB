package com.pattern.factory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/13
 * Time:11:03
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle:: draw() method.");
    }
}

package com.pattern.factory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/13
 * Time:11:02
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle:: draw() method.");
    }
}

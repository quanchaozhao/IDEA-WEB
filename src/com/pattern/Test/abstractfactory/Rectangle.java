package com.pattern.Test.abstractfactory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/15
 * Time:9:54
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("In rectangle shape.");
    }
}

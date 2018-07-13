package com.pattern.abstractfactory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/13
 * Time:12:43
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("In shape square.");
    }
}

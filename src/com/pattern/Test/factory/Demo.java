package com.pattern.Test.factory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/15
 * Time:9:41
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class Demo {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Shape circleShape = factory.getShape("circle");
        circleShape.draw();
        Shape squareShape = factory.getShape("square");
        squareShape.draw();
//        NullPointerException
//        Shape nullShape = factory.getShape("nono");
//        nullShape.draw();
    }
}

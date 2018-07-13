package com.pattern.Test.abstractfactory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/15
 * Time:10:08
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class Demo {
    public static void main(String[] args) {
        GetFactory getFactory = new GetFactory();
        AbstractFactory shapeFactory = getFactory.getFactory("shape");
        Shape circleShape = shapeFactory.getShape("circle");
        circleShape.draw();

        AbstractFactory colorFactory = getFactory.getFactory("color");
        Color blackColor = colorFactory.getColor("black");
        blackColor.fill();
    }
}

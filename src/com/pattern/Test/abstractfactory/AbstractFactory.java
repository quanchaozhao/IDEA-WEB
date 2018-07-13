package com.pattern.Test.abstractfactory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/15
 * Time:9:58
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
    abstract Color getColor(String colorType);
}

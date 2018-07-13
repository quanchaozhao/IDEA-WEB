package com.pattern.abstractfactory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/13
 * Time:12:47
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractFactory {
   abstract Shape getShape(String shape);
   abstract Color getColor(String color);
}

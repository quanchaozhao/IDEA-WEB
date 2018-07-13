package com.pattern.abstractfactory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/13
 * Time:12:55
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}

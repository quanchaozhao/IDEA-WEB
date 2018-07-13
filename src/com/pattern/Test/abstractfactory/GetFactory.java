package com.pattern.Test.abstractfactory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/15
 * Time:10:04
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class GetFactory {
    public AbstractFactory getFactory(String factoryType){
        if(factoryType == null){
            return null;
        } else if (factoryType.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if (factoryType.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}

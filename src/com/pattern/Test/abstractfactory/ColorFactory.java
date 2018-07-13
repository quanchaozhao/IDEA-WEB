package com.pattern.Test.abstractfactory;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/15
 * Time:10:02
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class ColorFactory extends AbstractFactory{
    @Override
    Shape getShape(String shapeType) {
        return null;
    }

    @Override
    Color getColor(String colorType) {
        if (colorType == null){
            return null;
        } else if (colorType.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if (colorType.equalsIgnoreCase("BLACK")){
            return new Black();
        }
        return null;
    }
}

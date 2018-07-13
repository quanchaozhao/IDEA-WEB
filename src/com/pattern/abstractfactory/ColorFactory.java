package com.pattern.abstractfactory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/13
 * Time:12:53
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class ColorFactory extends AbstractFactory {
    @Override
    Shape getShape(String shapeType) {
        return null;
    }

    @Override
    Color getColor(String colorType) {
        if (colorType == null)
            return null;
        else if (colorType.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (colorType.equalsIgnoreCase("BLUE")){
            return new Blue();
        }

        return null;
    }
}

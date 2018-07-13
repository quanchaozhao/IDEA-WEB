package com.pattern.abstractfactory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/13
 * Time:12:48
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }else if (shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }else if (shapeType.equalsIgnoreCase("Circle")){
            return new Circle();
        }
        return null;
    }

    @Override
    Color getColor(String color) {
        return null;
    }
}

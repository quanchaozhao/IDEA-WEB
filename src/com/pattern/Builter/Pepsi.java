package com.pattern.Builter;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/26
 * Time:10:17
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}

package com.pattern.Builter;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/26
 * Time:10:14
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}

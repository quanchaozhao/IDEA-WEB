package com.pattern.Builter;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/26
 * Time:10:12
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Vegetables Bugger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}

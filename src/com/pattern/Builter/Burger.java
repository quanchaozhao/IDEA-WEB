package com.pattern.Builter;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/26
 * Time:10:09
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public abstract class Burger implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}

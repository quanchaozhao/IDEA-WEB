package com.pattern.Test.abstractfactory;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/15
 * Time:9:57
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("in filled green.");
    }
}

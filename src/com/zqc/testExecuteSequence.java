package com.zqc;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/12
 * Time:8:57
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class testExecuteSequence extends TestFarther {
    String name = "subName";
    public testExecuteSequence() {
        System.out.println("sub");
//        printName();
    }

    public static void main(String[] args) {
                      new testExecuteSequence();
    }

    @Override
    void printName() {
        System.out.println(name);
    }

    static{
        System.out.println("in sub static!");
    }
    {
        System.out.println("in sub  construct");
    }
}

class TestFarther{
    String name = "fartherName";
    TestFarther(){
        System.out.println("father");
        printName();
    }
    static{
        System.out.println("in the farther static!");
    }
    {
        System.out.println("in the farther construct");
    }
    void printName(){
        System.out.println(name);

    }
}
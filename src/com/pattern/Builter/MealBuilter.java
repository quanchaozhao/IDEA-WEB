package com.pattern.Builter;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/26
 * Time:10:29
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class MealBuilter {
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareChickenBurger(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}

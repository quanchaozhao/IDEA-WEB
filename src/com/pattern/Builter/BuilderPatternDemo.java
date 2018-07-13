package com.pattern.Builter;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/26
 * Time:10:32
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilter mealBuilter = new MealBuilter();
        Meal vegMeal = mealBuilter.prepareVegMeal();
        System.out.println("Vegetable Meal");
        vegMeal.showItems();
        System.out.println("Total cost: " + vegMeal.getCost());
    }
}

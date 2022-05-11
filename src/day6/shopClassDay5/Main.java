package day6.shopClassDay5;

import exercises.day5.exercise6.Category;
import exercises.day5.exercise6.Clothes;
import exercises.day5.exercise6.Electronics;
import exercises.day5.exercise6.Fruits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Clothes cloth1 = new Clothes("Jeans", 50, Category.NEW);
        Clothes cloth2 = new Clothes("T-shirt", 80, Category.REFURBISHED);
        Clothes cloth3 = new Clothes("Plover", 15, Category.ON_SALE);
        Clothes cloth4 = new Clothes("Shorts", 10, Category.NEW);
        Clothes cloth5 = new Clothes("Blue jeans", 12, Category.NEW);
        Clothes cloth6 = new Clothes("cheap jeans", 40, Category.NEW);
        List<Clothes> clothList = new ArrayList<>(Arrays.asList(cloth1, cloth2, cloth3, cloth4, cloth6));

        Shop<Clothes> shop1 = new Shop<>(clothList);
        System.out.println("The shop items are:" + shop1);
        System.out.println("We add a new item in the shop:");
        shop1.addItem(cloth5);
        System.out.println("The shop items are:" + shop1);
        System.out.printf("The items by category %s are: " + shop1.findByCategory(Category.NEW), Category.NEW);
        System.out.println();
        System.out.println("The items by higher price then 20 are: " + shop1.findWithHigherPrice(20));
        System.out.println("The items by lower price then 20 are: " + shop1.findWithLowerPrice(20));
        System.out.println("The output result of findByName method: " + shop1.findByName("shorts"));
        System.out.println("The shop items are:" + shop1);
        System.out.println("We remove the item: " + shop1.removeItem("cheap jeans"));
        System.out.println("The shop items are:" + shop1);

        Fruits fruit1 = new Fruits("Apple", 1, Category.ON_SALE);
        Fruits fruit2 = new Fruits("Kiwi", 2, Category.ON_SALE);
        Fruits fruit3 = new Fruits("Banana", 1, Category.ON_SALE);
        Fruits fruit4 = new Fruits("Plum", 2, Category.ON_SALE);
        Fruits fruit5 = new Fruits("Orange", 5, Category.ON_SALE);
        Fruits fruit6 = new Fruits("Melon", 10, Category.ON_SALE);
        List<Fruits> fruitsList = new ArrayList<>(Arrays.asList(fruit1, fruit2, fruit3, fruit4, fruit6));

        Shop<Fruits> fruitShop = new Shop<>(fruitsList);

        Electronics electronics1 = new Electronics("SmartTV", 1360, Category.ON_SALE);
        Electronics electronics2 = new Electronics("Radio", 200, Category.ON_SALE);
        Electronics electronics3 = new Electronics("Samsung S10", 1800, Category.ON_SALE);
        Electronics electronics4 = new Electronics("Refrigerator", 2100, Category.ON_SALE);
        Electronics electronics5 = new Electronics("21'' Monitor", 500, Category.ON_SALE);
        Electronics electronics6 = new Electronics("Mouse", 50, Category.ON_SALE);
        List<Electronics> electronicsList = new ArrayList<>(Arrays.asList(electronics1, electronics2, electronics3, electronics4, electronics6));

        Shop<Electronics> electronicsShop = new Shop<>(electronicsList);

    }


}

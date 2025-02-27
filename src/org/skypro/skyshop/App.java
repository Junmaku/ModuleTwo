package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {

    public static void main(String[] args) throws BestResultFound {
        ProductBasket newBasket = new ProductBasket();
        Product potato = new FixPriceProduct("Potato");
        Product salad = new DiscountedProduct("Salad", 45, 5);
        Product carrot = new SimpleProduct("Carrot", 40);

//
//        newBasket.addProduct(carrot);
//        newBasket.addProduct(salad);
//        newBasket.addProduct(salad);
//        newBasket.addProduct(potato);
//        newBasket.addProduct(carrot);
//        newBasket.printBasket();
//        System.out.println(newBasket.getBasketPrice());
//        System.out.println(newBasket.checkProduct("Carrot"));
//        System.out.println(newBasket.checkProduct("Anything"));
//        newBasket.cleanBasket();
//        newBasket.printBasket();
//        newBasket.getBasketPrice();
//        System.out.println(newBasket.checkProduct("Carrot"));
        //hw#3
        SearchEngine poisk = new SearchEngine(5);
        Article text1 = new Article("Energy drink", "Red bull is most popular energy drink in the world.");
        Article text2 = new Article("Glasses", "Rayban is most popular glasses in the world.");
        Article text3 = new Article("Car", "One of the most popular car is Toyota from Japan.");
        poisk.add(text1);
        poisk.add(text2);
        poisk.add(text3);
        System.out.println(Arrays.toString(poisk.search("popular")));
        System.out.println();
        System.out.println(Arrays.toString(poisk.search("Japan")));
        //hw#4
        try {
            Article text4 = new Article("  ", "One of the most popular car is Toyota from Japan.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product wrongProduct2 = new SimpleProduct("someName", 0);
            Product wrongProduct = new SimpleProduct("   ", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(poisk.getMostSuitableObject("most").toString());
        System.out.println(poisk.getMostSuitableObject("Promo"));
    }
}

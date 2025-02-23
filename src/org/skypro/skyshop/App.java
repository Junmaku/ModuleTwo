package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    static ProductBasket newBasket = new ProductBasket();
    static Product carrot = new SimpleProduct("Carrot", 40);
    static Product salad = new DiscountedProduct("Salad", 45, 5);
    static Product potato = new FixPriceProduct("Potato");

    public static void main(String[] args) {
        newBasket.addProduct(carrot);
        newBasket.addProduct(salad);
        newBasket.addProduct(salad);
        newBasket.addProduct(potato);
        newBasket.addProduct(carrot);
        newBasket.printBasket();
        System.out.println(newBasket.getBasketPrice());
        System.out.println(newBasket.checkProduct("Carrot"));
        System.out.println(newBasket.checkProduct("Anything"));
        newBasket.cleanBasket();
        newBasket.printBasket();
        newBasket.getBasketPrice();
        System.out.println(newBasket.checkProduct("Carrot"));
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


    }
}

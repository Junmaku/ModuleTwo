package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    static ProductBasket newBasket = new ProductBasket();
    static Product carrot = new Product("Carrot", 40);
    static Product salad = new Product("Salad", 45);
    static Product potato = new Product("Potato", 35);

    public static void main(String[] args) {
        newBasket.addProduct(carrot);
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


    }
}

package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

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


    }
}

package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, LinkedList<Product>> basketMap = new HashMap<>();

    public void addProduct(Product prod) {
        basketMap.computeIfAbsent(prod.getName(), k -> new LinkedList<>()).add(prod);
    }

    public int getBasketPrice() {
        int sum = 0;
        for (LinkedList<Product> products : basketMap.values()) {
            for (Product product : products) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        int count = 0;
        for (LinkedList<Product> products : basketMap.values()) {
            for (Product product : products) {
                System.out.println(product);
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        if (basketMap.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + getBasketPrice());
            System.out.println(count > 0 ? String.format("Специальных товаров: %d", count) : "");
        }
    }

    public boolean checkProduct(String name) {
        name = name.trim();
        return basketMap.containsKey(name);
    }

    public void cleanBasket() {
        basketMap.clear();
    }

    public LinkedList<Product> removeProduct(String name) {
        LinkedList<Product> tempList = new LinkedList<>();
        if (basketMap.containsKey(name)) {
            tempList.addAll(basketMap.get(name));
        } else {
            System.out.println(basketMap.isEmpty() ? "List is empty!" : "Not found product in list");
        }
        return tempList;
    }

    public void removeOneProduct(String name) {
        if (basketMap.containsKey(name)) {
            basketMap.get(name).removeFirst();
            if (basketMap.get(name).isEmpty()) {
                basketMap.remove(name);
            }
            System.out.println("Product is removed");
        } else {
            System.out.println(basketMap.isEmpty() ? "List is empty!" : "Not found product in list");
        }
    }


}

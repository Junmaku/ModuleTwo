package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private List<Product> basket = new LinkedList<>();

    public void addProduct(Product prod) {
        basket.add(prod);
    }

    public int getBasketPrice() {
        int sum = 0;
        for (Product product : basket) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        if (sum != 0) {
            return sum;
        } else {
            System.out.println("В корзине пусто.");
            return 0;
        }
    }

    public void printBasket() {
        boolean flag = false;
        int count = 0;
        for (Product product : basket) {
            if (product != null) {
                flag = true;
                System.out.println(product);
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        if (!flag) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + getBasketPrice());
            System.out.println(count > 0 ? String.format("Специальных товаров: %d", count) : "");
        }
    }

    public boolean checkProduct(String name) {
        for (Product product : basket) {
            if (product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        basket.clear();
    }

    public LinkedList<Product> removeProduct(String name) {
        LinkedList<Product> tempList = new LinkedList<>();
        Iterator<Product> iterator = basket.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Product temp = iterator.next();
            if (temp.getName().equalsIgnoreCase(name)) {
                tempList.add(temp);
                iterator.remove();
                count++;
            }
        }
        if (count != 0) {
            return tempList;
        } else {
            System.out.println("Список пуст!");
            return tempList;
        }
    }


}

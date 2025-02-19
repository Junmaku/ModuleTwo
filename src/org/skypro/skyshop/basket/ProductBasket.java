package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final int SIZE = 5;
    private Product[] basket = new Product[SIZE];

    public void addProduct(Product prod) {
        boolean flag = false;
        for (int i = 0; i < SIZE; i++) {
            if (basket[i] == null) {
                basket[i] = prod;
                flag = true;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт.");
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
        boolean flag = false;
        for (Product product : basket) {
            if (product != null) {
                flag = product.getName().equalsIgnoreCase(name);
                if (flag) {
                    return flag;
                }
            }
        }
        return flag;
    }

    public void cleanBasket() {
        for (int i = 0; i < SIZE; i++) {
            basket[i] = null;
        }
    }


}

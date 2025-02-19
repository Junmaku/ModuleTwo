package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("%s: %d", super.getName(), getPrice());
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}

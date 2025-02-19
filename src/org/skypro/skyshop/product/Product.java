package org.skypro.skyshop.product;

abstract public class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public int getPrice();

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }

    abstract public boolean isSpecial();
}

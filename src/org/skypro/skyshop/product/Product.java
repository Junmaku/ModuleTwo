package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

abstract public class Product implements Searchable {
    private String name;

    public Product(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Поле name не может быть пустым.");
        }
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

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}

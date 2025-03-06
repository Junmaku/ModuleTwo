package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

abstract public class Product implements Searchable {
    private final String name;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}

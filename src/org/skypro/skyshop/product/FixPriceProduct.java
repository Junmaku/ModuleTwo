package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return String.format("%s: Фиксированная цена %d", super.getName(), getPrice());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}

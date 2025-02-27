package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basicPrice;
    private int discount;

    public void setDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапозоне от 0 до 100!");
        }
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public DiscountedProduct(String name, int basicPrice, int discount) {
        super(name);
        setDiscount(discount);
        if (basicPrice < 1) {
            throw new IllegalArgumentException("Базовая цена не может быть меньше 1!");
        }
        this.basicPrice = basicPrice;
    }

    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return (basicPrice + (basicPrice * discount / 100));
    }

    @Override
    public String toString() {
        return String.format("%s: %d (%d%%)", super.getName(), getPrice(), getDiscount());
    }
}

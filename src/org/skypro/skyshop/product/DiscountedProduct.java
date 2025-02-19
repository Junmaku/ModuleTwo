package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basicPrice;
    private int discount;

    public void setDiscount(int discount) {
        if (discount < 0) {
            this.discount = 0;
        }
        else if (discount > 100) {
            this.discount = 100;
        } else {
            this.discount = discount;
        }
    }

    public int getDiscount() {
        return discount;
    }

    public DiscountedProduct(String name, int basicPrice, int discount) {
        super(name);
        this.basicPrice = basicPrice;
        setDiscount(discount);
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

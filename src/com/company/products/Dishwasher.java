package com.company.products;

public class Dishwasher extends Product {
    protected final ProductType PRODUCT_TYPE = ProductType.DISHWASHER;
    int width;

    public Dishwasher(String model, int price, double rating, int article, String color, int width) {
        super(model, price, rating, article, color);
        this.width = width;
    }

    @Override
    public ProductType getProductType() {
        return PRODUCT_TYPE;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "\nПосудомоечная машина: " + super.getModel() +
                "\nЦена: " + super.getPrice() + " рублей" +
                "  Рейтинг: " + super.getRating() +
                "  Артикул: " + super.getArticle() +
                "  Цвет: " + super.getColor() +
                "  Ширина: " + getWidth() + "см";
    }
}

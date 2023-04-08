package com.company.products;

public class Fridge extends Product {
    protected final ProductType PRODUCT_TYPE = ProductType.FRIDGE;
    String freezer;

    public Fridge(String model, int price, double rating, int article, String color, String freezer) {
        super(model, price, rating, article, color);
        this.freezer = freezer;
    }

    @Override
    public ProductType getProductType() {
        return PRODUCT_TYPE;
    }

    public String getFreezer() {
        return freezer;
    }

    @Override
    public String toString() {
        return "\nХолодильник: " + super.getModel() +
                "\nЦена : " + super.getPrice() + " рублей" +
                " Рейтинг: " + super.getRating() +
                " Артикул: " + super.getArticle() +
                " Цвет: " + super.getColor() +
                " Наличие морозильной камеры: " + getFreezer();
    }
}

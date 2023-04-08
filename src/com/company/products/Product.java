package com.company.products;

public abstract class Product{
    String model;
    int price;
    double rating;
    int article;
    String color;

    public Product(String model, int price, double rating, int article, String color) {
        this.model = model;
        this.price = price;
        this.rating = rating;
        this.article = article;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public int getArticle() {
        return article;
    }

    public String getColor() {
        return color;
    }

    public abstract ProductType getProductType();

    @Override
    public String toString() {
        return "\nПродукт: " + model +
                "\nЦена: " + price + " рублей" +
                "  Рейтинг: " + rating +
                "  Артикул: " + article +
                "  Цвет: " + color;
    }
}

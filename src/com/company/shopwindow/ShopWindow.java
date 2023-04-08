package com.company.shopwindow;

import com.company.interfaces.Sorting;
import com.company.products.Product;
import com.company.products.ProductType;
import com.company.interfaces.ListPrinter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShopWindow implements Sorting, ListPrinter {
    private static List<Product> shopWindow = new ArrayList<>();

    public void addProduct(Product product) {
        shopWindow.add(product);
    }

    @Override
    public void printAllItems() {
        for (Product product : shopWindow) {
            System.out.println(product);
        }
    }

    public void printDishwasherList() {
        for (Product product : shopWindow) {
            if (product.getProductType() == ProductType.DISHWASHER) {
                System.out.println(product + "\n");
            }
        }
    }

    public void printFridgeList() {
        for (Product product : shopWindow) {
            if (product.getProductType() == ProductType.FRIDGE) {
                System.out.println(product + "\n");
            }
        }
    }

    @Override
    public void sortByRating() {
        shopWindow.sort(Comparator.comparingDouble(Product::getRating));
    }


    @Override
    public void sortByPrice() {
        shopWindow.sort(Comparator.comparingInt(Product::getPrice));
    }

    public Product getProductByArticle(int article) {
        for (Product product : shopWindow) {
            if (product.getArticle() == article) {
                return product;
            }
        }
        throw new IllegalStateException("Введен неверный номер артикула.");
    }


}


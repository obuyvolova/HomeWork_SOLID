package com.company.shoppingcart;

import com.company.products.Product;
import com.company.interfaces.ListPrinter;

import java.util.ArrayList;

public class ShoppingCart implements ListPrinter {
    public static ArrayList<Product> shoppingCart = new ArrayList<>();

    public void addItemToCard(Product product) {
        shoppingCart.add(product);
    }

    public void removeItemFromCard(Product product) {
        shoppingCart.remove(product);
    }

    @Override
    public void printAllItems() {
        if (shoppingCart.isEmpty()) {
            System.out.println("Ваша корзина пуста!");
        }
        for (Product product : shoppingCart) {
            System.out.println(product);
        }
    }

    public void deleteAllItems() {
        shoppingCart.removeAll(shoppingCart);
    }


}

package com.example.hassan.viewpager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataProvider {
    public final static List<Product> productList = new ArrayList<>();
    public static final Map<String, Product> productMap = new HashMap<>();

    static {
        addProduct("one",
                "Shirt under denim",
                "Old ass gangster wearing shirt under a blue denim jacket made with 10% cotton for form and support. He also has a brown breads, shiorr.",
                99.00);
        addProduct("two",
                "Varsity Jacket",
                "White boy wearing a black varsity jacket made with 15% fibre for form and support.",
                65);
        addProduct("three",
                "Blue shirt",
                "Plain blue shirt from google",
                10);
        addProduct("four",
                "Hoodie",
                "A wine color hoodie, designed by hoodie melo. If you wanna loose like him, order for it",
                175);
        addProduct("five",
                "Dope outfit",
                "Young boy looking dope on a white shirt under a brown denim jacket. Fresh af",
                250);
        addProduct("six",
                "Camouflage",
                "Don't wear this in Nigeria",
                450);
        addProduct("seven",
                "Puma",
                "A black puma hoodie designed for form and comfort, It's fresh",
                120);
    }

    private static void addProduct(String productId, String name, String description, double price) {
        Product item = new Product(productId, name, description, price);
        productList.add(item);
        productMap.put(productId, item);
    }

    public static List<String> getProductNames() {
        List<String> list = new ArrayList<>();
        for (Product product : productList) {
            list.add(product.getName());
        }
        return list;
    }

    public static List<Product> getFilteredList(String searchString) {
        List<Product> filteredList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductId().contains(searchString)) {
                filteredList.add(product);
            }
        }
        return filteredList;
    }
}

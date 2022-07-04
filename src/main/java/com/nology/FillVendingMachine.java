package com.nology;

import java.util.ArrayList;
import java.util.List;

public class FillVendingMachine {

    List<Product> products = new ArrayList<>();

    private List<Product> fillVendingMachine() {
        products.add(new Drink("Coke",2, 5));
        products.add(new Drink("Fanta", 2, 5));
        products.add(new Drink ("Still Water", 1, 5));
        products.add(new Drink("Sparkling Water", 1, 5));
        products.add(new Drink ("Lemon Ice Tea", 1.8, 5));
        products.add(new Drink ("Apple Juice", 1.5, 5));
        products.add(new CerealBars("Peanuts & Chocolate Bar", 1.20, 8));
        products.add(new CerealBars("Oats & Maple Syrup Bar", 1.20, 8));
        products.add(new CerealBars("Fruit & Nut Bar", 1.20, 8));
        products.add(new ChocolateBars("Mars", 1.50, 8));
        products.add(new ChocolateBars("Twix", 1.50, 8));
        products.add(new ChocolateBars("Snickers", 1.50, 8));
        products.add(new ChocolateBars("Kinder Bueno", 1.50, 8));
        products.add(new Crisps("Salted Crisps", 1.1, 6));
        products.add(new Crisps("Cheese & Onion Crisps", 1.1, 6));
        products.add(new Crisps ("Bbq Crisps", 1.1, 6));
        return products;
    }

    public List<Product> getProducts() {
        fillVendingMachine();
        return products;
    }
}

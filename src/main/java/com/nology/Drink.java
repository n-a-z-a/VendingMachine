package com.nology;

public class Drink extends Product {

    public Drink(String name, double price, int maxAmount) {
        super(name, "drink", price, maxAmount, 0);
    }
}

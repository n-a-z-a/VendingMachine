package com.nology;

public class Product {

    private String name, category;
    private double price;
    private int maxAmount, availableAmount;

    public Product(String name, String category, double price, int maxAmount, int availableAmount) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.maxAmount = maxAmount;
        this.availableAmount = availableAmount;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }


    public double getPrice() {
        return price;
    }


    public int getMaxAmount() {
        return maxAmount;
    }


    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }
}

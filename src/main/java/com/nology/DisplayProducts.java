package com.nology;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DisplayProducts {

    FillVendingMachine fillVendingMachine = new FillVendingMachine();
    List<Product> products = fillVendingMachine.getProducts();
    private int availableAmount = 0;

    private int getAvailableAmount(int min, int max) {
        return (int) (Math.random() * (max - min + 0) + min);
    }

    public void sortProductsByCategoryAndName() {
        Comparator<Product> productComparator = new SortByCategoryAndPriceComparator();
        Collections.sort(products, productComparator);
    }


    public List<Product> stockProductsAtLoading(List<Product> products, int availableAmount) {
        sortProductsByCategoryAndName();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            availableAmount = getAvailableAmount((product.getMaxAmount() + 1), 0);
            products.get(i).setAvailableAmount(availableAmount);
        }
        return products;
    }

    public void printProducts (List < Product > products){
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getAvailableAmount() != 0) {
                    System.out.println("code " + i +
                            ", " + products.get(i).getName() +
                            ", category: " + products.get(i).getCategory() +
                            ", price: £" + products.get(i).getPrice() +
                            ", " + products.get(i).getAvailableAmount() + " in stock");
                } else {
                    System.out.println("code " + i
                            + ", " + products.get(i).getName()
                            + ", category: " + products.get(i).getCategory()
                            + ", price: £" + products.get(i).getPrice()
                            + ", out of stock");
                }
            }
        }
}


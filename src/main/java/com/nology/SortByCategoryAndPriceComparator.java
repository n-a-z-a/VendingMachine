package com.nology;

import java.util.Comparator;

public class SortByCategoryAndPriceComparator implements Comparator<Product> {


    @Override
    public int compare(Product firstProduct, Product secondProduct) {

        int categoryCompare = firstProduct.getCategory().compareTo((secondProduct.getCategory()));
        int nameCompare = firstProduct.getName().compareTo((secondProduct.getName()));
        return (categoryCompare==0) ? nameCompare : categoryCompare;
    }
}

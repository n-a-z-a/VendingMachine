package com.nology;

import java.util.List;
import java.util.Scanner;

public class TakeStock {

    private Scanner scanner = new Scanner( System.in );

    public void takeStock(List<Product> products) {
        double totalValueUnsoldItems = 0;
        for (int i = 0; i < products.size(); i++) {
            System.out.println("code " + i + ", " +
                    products.get(i).getName() +
                    " - quantity unsold: " +
                    products.get(i).getAvailableAmount() +
                    " - value: £" +
                    (Math.round((products.get(i).getAvailableAmount() * products.get(i).getPrice())*100d)/100d));
            totalValueUnsoldItems += (products.get(i).getAvailableAmount()*products.get(i).getPrice());

        }
        System.out.println("Total value of unsold products: £" + (Math.round(totalValueUnsoldItems*100d)/100d));
        System.out.println("-----------------------");
        System.out.println("Press enter to continue:");
        scanner.nextLine();
    }
}

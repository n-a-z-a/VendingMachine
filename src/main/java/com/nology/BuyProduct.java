package com.nology;

import java.util.List;
import java.util.Scanner;

public class BuyProduct {
    private Scanner scanner = new Scanner(System.in);


    public void buyProduct(List<Product> products) {
        System.out.println("Please enter the code for the item you wish to buy:");
        while (true) {
            String scan = scanner.nextLine();
            if (scan.matches("[0-9]+")) {
                int code = Integer.parseInt(scan);
                if (code >= 0 && code < 16 && products.get(code).getAvailableAmount() == 0) {
                    System.out.println(products.get(code).getName() + " is out of stock. ");
                    System.out.println("Please select a different product:");
                } else if (code >= 0 && code < 16) {
                    System.out.println("You selected " +
                            products.get(code).getName() +
                            ", the price is £" +
                            products.get(code).getPrice() +
                            ", please insert the money: ");
                    double moneyInserted = Double.parseDouble(scanner.nextLine());
                    while (true) {
                        if (moneyInserted < products.get(code).getPrice()) {
                            System.out.println("Please insert at least £" + products.get(code).getPrice());
                            moneyInserted = Double.parseDouble(scanner.nextLine());
                        } else {
                            System.out.println("Here is your " +
                                    products.get(code).getName() +
                                    " and your change is: £" +
                                    ((Math.round((moneyInserted - products.get(code).getPrice()) * 100d) / 100d)) +
                                    ". Thank you for your purchase!");
                            System.out.println("-----------------------");
                            products.get(code).setAvailableAmount(products.get(code).getAvailableAmount() - 1);
                            break;
                        }
                    }
                    break;
                } else {
                    System.out.println("Please enter a number between 0 and 15:");
                }
            } else {
                System.out.println("Please enter a number between 0 and 15:");
            }
        }
    }
}

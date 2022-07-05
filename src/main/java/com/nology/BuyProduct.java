package com.nology;

import java.util.List;
import java.util.Scanner;

public class BuyProduct{
    private Scanner scanner = new Scanner(System.in);

    private boolean isValidInput(String input) {
        if (input.matches("^[0-9]*\\.?[0-9]+$")) {
            return true;
        }
        return false;
    }

    public void buyProduct(List<Product> products) {
        System.out.println("Please enter the code for the item you wish to buy:");
        String scan = null;
        while (true) {
            scan = scanner.nextLine();
            if (isValidInput(scan) && Integer.parseInt(scan) >= 0 && Integer.parseInt(scan) < 16) {
                int code = Integer.parseInt(scan);
                if (code >= 0 && code < 16 && products.get(code).getAvailableAmount() == 0) {
                    System.out.println(products.get(code).getName() + " is out of stock. ");
                    System.out.println("Please select a different product:");
                } else {
                    System.out.println("You selected " +
                            products.get(code).getName() +
                            ", the price is £" +
                            products.get(code).getPrice() +
                            ", please insert the money: ");
                    while (true) {
                        String moneyInsertedScan = scanner.nextLine();
                        if (isValidInput(moneyInsertedScan)) {
                            double moneyInserted = Double.parseDouble(moneyInsertedScan);
                            while (true) {
                                if (moneyInserted < products.get(code).getPrice()) {
                                    System.out.println("Please insert at least £" + products.get(code).getPrice());
                                    moneyInsertedScan = scanner.nextLine();
                                    if (isValidInput(moneyInsertedScan)) {
                                        moneyInserted = Double.parseDouble(moneyInsertedScan);
                                    }
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
                            System.out.println("Please insert a valid amount:");
                        }
                    }
                    break;
                }
            } else {
                    System.out.println("Please enter a number between 0 and 15:");
            }
        }
    }
}

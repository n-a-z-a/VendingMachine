package com.nology;

import java.util.List;
import java.util.Scanner;

public class RefillVendingMachine {
    private Scanner scanner = new Scanner( System.in );

    public void refillVendingMachine(List<Product> products) {
        System.out.println("Please enter the code for the item you wish to refill:");
        while (true) {
            String codeScan = scanner.nextLine();
            if (codeScan.matches("[0-9]+")) {
                int code = Integer.parseInt(codeScan);
                if (code >= 0 && code < 16) {
                    if (products.get(code).getAvailableAmount() == products.get(code).getMaxAmount()) {
                        System.out.println("The product you selected is already at its maximum stock level");
                        System.out.println("Please select another product:");
                        code = Integer.parseInt(scanner.nextLine());
                    } else {
                        System.out.println("You selected " +
                                products.get(code).getName() +
                                ", the current stock level is " +
                                products.get(code).getAvailableAmount() +
                                ", please enter amount to add:");
                    }
                    int amountEntered = Integer.parseInt(scanner.nextLine());
                    while (true) {
                        if ((products.get(code).getAvailableAmount() + amountEntered) > products.get(code).getMaxAmount()) {
                            System.out.println("The stock level for this product cannot exceed " +
                                    products.get(code).getMaxAmount() +
                                    ". Please enter a valid amount to add:");
                            amountEntered = Integer.parseInt(scanner.nextLine());
                        } else {
                            products.get(code).setAvailableAmount(products.get(code).getAvailableAmount() + amountEntered);
                            System.out.println("Refill successful! The new stock level for " +
                                    products.get(code).getName() + " is " +
                                    products.get(code).getAvailableAmount() + ".");
                            System.out.println("-----------------------");
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

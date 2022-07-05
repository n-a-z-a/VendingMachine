package com.nology;

import java.util.List;
import java.util.Scanner;

public class RefillVendingMachine {
    private Scanner scanner = new Scanner( System.in );

    private boolean isValidInput(String input) {
        if (input.matches("[0-9]+")) {
            return true;
        }
        return false;
    }


    public void refillVendingMachine(List<Product> products) {
        System.out.println("Please enter the code for the item you wish to refill:");
        String codeScan = null;

        while (true) {
            codeScan = scanner.nextLine();
            if (isValidInput(codeScan) && Integer.parseInt(codeScan) >= 0 && Integer.parseInt(codeScan) < 16) {
                int code = Integer.parseInt(codeScan);
                if (products.get(code).getAvailableAmount() == products.get(code).getMaxAmount()) {
                    System.out.println("The product you selected is already at its maximum stock level.");
                    System.out.println("Please select another product:");
                } else {
                    System.out.println("You selected " +
                            products.get(code).getName() +
                            ", the current stock level is " +
                            products.get(code).getAvailableAmount() +
                            ", please enter amount to add:");
                    String amountToAddScan = scanner.nextLine();
                    while (true) {
                        if (isValidInput(amountToAddScan)) {
                            int amountEntered = Integer.parseInt(amountToAddScan);
                            if ((products.get(code).getAvailableAmount() + amountEntered) > products.get(code).getMaxAmount()) {
                                System.out.println("The stock level for this product cannot exceed " +
                                        products.get(code).getMaxAmount() +
                                        ". Please enter a valid amount to add:");
                                amountToAddScan = scanner.nextLine();
                            } else {
                                products.get(code).setAvailableAmount(products.get(code).getAvailableAmount() + amountEntered);
                                System.out.println("Refill successful! The new stock level for " +
                                        products.get(code).getName() + " is " +
                                        products.get(code).getAvailableAmount() + ".");
                                System.out.println("-----------------------");
                                break;
                            }
                        } else {
                            System.out.println("Please enter a valid amount to add:");
                            amountToAddScan = scanner.nextLine();
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

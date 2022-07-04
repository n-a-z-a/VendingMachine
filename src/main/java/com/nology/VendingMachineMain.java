package com.nology;

import java.util.*;

public class VendingMachineMain {

    private Scanner scanner = new Scanner( System.in );
    private int availableAmount = 0;


    DisplayProducts displayProducts = new DisplayProducts();
    List<Product> products = displayProducts.stockProductsAtLoading(displayProducts.products, availableAmount);

    BuyProduct buyProduct = new BuyProduct();
    RefillVendingMachine refillVendingMachine = new RefillVendingMachine();
    TakeStock takeStock = new TakeStock();


    private String displayCommandOptions() {
        System.out.println("-----------------------");
        System.out.println("01 - Buy");
        System.out.println("02 - Refill");
        System.out.println("03 - Take Stock");
        System.out.println("04 - Exit");
        System.out.println("Please select a command:");
        String command = scanner.nextLine().replace(" ", "");
        return command;
    }

    public void runVendingMachine() {
        System.out.println("------- VENDING MACHINE -------");
        displayProducts.printProducts(products);
        String command = displayCommandOptions();
        while (true) {
            if (command.equals("01")) {
                buyProduct.buyProduct(products);
                runVendingMachine();
            } else if (command.equals("02")) {
                refillVendingMachine.refillVendingMachine(products);
                runVendingMachine();
            } else if (command.equals("03")) {
                takeStock.takeStock(products);
                runVendingMachine();
            } else if (command.equals("04")) {
                System.out.println("Goodbye!");
                break;
            } else {
                    System.out.println("Please choose between 01, 02, 03 or 04:");
                    command = scanner.nextLine().replace(" ", "");
                }
            }
        }



    public static void main(String[] args) {

        VendingMachineMain vendingMachine = new VendingMachineMain();
        vendingMachine.runVendingMachine();

    }

}

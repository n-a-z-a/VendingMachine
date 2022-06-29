package com.nology;

import java.util.*;

public class VendingMachine {

    private int stock, availableAmount;
    private Scanner scanner = new Scanner( System.in );



    Drink coke = new Drink("Coke",2, 5);
    Drink fanta = new Drink("Fanta", 2, 5);
    Drink stillWater = new Drink ("Still Water", 1, 5);
    Drink sparklingWater = new Drink("Sparkling Water", 1, 5);
    Drink lemonIceTea = new Drink ("Lemon Ice Tea", 1.8, 5);
    Drink appleJuice = new Drink ("Apple Juice", 1.5, 5);

    CerealBars peanutsChocolateBar = new CerealBars("Peanuts & Chocolate Bar", 1.20, 8);
    CerealBars oatsMapleSyrupBar = new CerealBars("Oats & Maple Syrup Bar", 1.20, 8);
    CerealBars fruitNutBar = new CerealBars("Fruit & Nut Bar", 1.20, 8);

    ChocolateBars mars = new ChocolateBars("Mars", 1.50, 8);
    ChocolateBars twix = new ChocolateBars("Twix", 1.50, 8 );
    ChocolateBars snickers = new ChocolateBars("Snickers", 1.50, 8);
    ChocolateBars kinderBueno = new ChocolateBars("Kinder Bueno", 1.50, 8);

    Crisps saltedCrisps = new Crisps("Salted Crisps", 1.1, 6);
    Crisps cheeseOnionCrisps = new Crisps("Cheese & Onion Crisps", 1.1, 6);
    Crisps bbqCrisps = new Crisps ("Bbq Crisps", 1.1, 6);


    private Product[] products = new Product[] {coke, fanta, stillWater, sparklingWater, lemonIceTea, appleJuice, peanutsChocolateBar,oatsMapleSyrupBar, fruitNutBar, mars, twix, snickers, kinderBueno, saltedCrisps, cheeseOnionCrisps,bbqCrisps};

    public int getAvailableAmount(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public void sortProductsByCategoryAndName() {
        Comparator<Product> productComparator = new SortByCategoryAndPriceComparator();
        Collections.sort(Arrays.asList(products), productComparator);
    }


    public void displayProducts(Product[] products, int availableAmount) {
        sortProductsByCategoryAndName();
        for (int i = 0; i < products.length ; i++) {
            Product product = products[i];
            availableAmount = getAvailableAmount((product.getMaxAmount()+1), 0);
            products[i].setAvailableAmount(availableAmount);
            if (availableAmount != 0) {
                System.out.println("code " + i +
                        ", " + product.getName() +
                        ", price: £" + product.getPrice() +
                        ", " + availableAmount + " in stock");
            } else {
                System.out.println(product.getName() + ", out of stock");
            }
        }
    }

    public void startVendingMachine() {
        displayProducts(products, availableAmount);
        System.out.println("-----------------------");
        System.out.println("01 -Buy");
        System.out.println("02 -Refill");
        System.out.println("03 -Stock");
        System.out.println("Please select a command:");
        String command = scanner.nextLine().replace(" ", "");
        while (true) {
            if (command.equals("01")) {
                displayProducts(products, availableAmount);
                System.out.println("Please enter the code for the item you wish to buy:");
                while (true) {
                    int code = Integer.parseInt(scanner.nextLine());
                    if (code >= 0 && code < 16) {
                        System.out.println("You selected " +
                                products[code].getName() +
                                ", the price is £" +
                                products[code].getPrice() +
                                ", please insert the money: ");
                        int moneyInserted = Integer.parseInt(scanner.nextLine());
                        while (true) {
                            if (moneyInserted < products[code].getPrice()) {
                                System.out.println("Please insert at least £" + products[code].getPrice());
                                moneyInserted = Integer.parseInt(scanner.nextLine());
                            } else {
                                System.out.println("Here is your " + products[code].getName() + " and your change is: £" + (moneyInserted - products[code].getPrice()));
                                break;
                            }
                        }
                    } else {
                        System.out.println("Please enter a number between 1 and 16:");
                    }
                }
            }

            if (command.equals("02")) {
                displayProducts(products, availableAmount);
                System.out.println("Please enter the code for the item you wish to refill:");
                while (true) {
                    int code = Integer.parseInt(scanner.nextLine());
                    if (code >= 0 && code < 16) {
                        if (products[code].getAvailableAmount() == products[code].getMaxAmount()) {
                            System.out.println("The product you selected is already at its maximum stock level");
                            System.out.println("Please select another product:");
                            code = Integer.parseInt(scanner.nextLine());
                        } else {
                            System.out.println("You selected " +
                                    products[code].getName() +
                                    ", the current stock level is" +
                                    products[code].getAvailableAmount() +
                                    ", please enter amount to add:");
                        }
                        int amountEntered = Integer.parseInt(scanner.nextLine());
                        while (true) {
                            if ((products[code].getAvailableAmount() + amountEntered) > products[code].getMaxAmount()) {
                                System.out.println("The stock level for this product cannot exceed " + products[code].getMaxAmount() + ". Please enter a valid amount:");
                                amountEntered = Integer.parseInt(scanner.nextLine());
                            } else {
                                System.out.println("Refill successful! The new stock level for " + products[code].getName() + " is " + (products[code].getAvailableAmount() + amountEntered));
                                break;
                            }
                        }
                    } else {
                        System.out.println("Please enter a number between 1 and 16:");
                    }
                }
            }
            if (command.equals("03")) {

            } else {
                System.out.println("Please enter choose between 01, 02 or 03:");
            }
        }
    }



    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.startVendingMachine();

    }

}

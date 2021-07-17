package pl.glownia.pamela;

import java.util.Scanner;

public class MainMenu {
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        printCoffeeMachineState();
        makeDecision(scan);

        System.out.println();
        System.out.println("**********");
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    static void printCoffeeMachineState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    static void makeDecision(Scanner scan) {
        System.out.println("Write action(buy, fill, take): ");
        String decision = scan.next();
        if (decision.equalsIgnoreCase("buy")) {
            System.out.println("What do you want to buy? 1- espresso, 2- latte, 3-cappuccino");
            int coffeeNumber = scan.nextInt();
            if (coffeeNumber == 1) {
                makeEspresso();
            } else if (coffeeNumber == 2) {
                makeLatte();
            } else if (coffeeNumber == 3) {
                makeCappuccino();

            } else {
                System.out.println("Wrong number.");
            }
        } else if (decision.equalsIgnoreCase("fill")) {
            System.out.println("Under construction...");
        } else if (decision.equalsIgnoreCase("take")) {
            System.out.println("Under construction...");
        } else {
            throw new IllegalArgumentException("Incorrect value.");
        }
    }

    static void makeEspresso() {
        water -= 250;
        coffeeBeans -= 16;
        money += 4;
        cups -= 1;
        printCoffeeMachineState();
    }

    static void makeLatte() {
        water -= 350;
        milk -= 75;
        coffeeBeans -= 20;
        money += 7;
        cups -= 1;
        printCoffeeMachineState();
    }

    static void makeCappuccino() {
        water -= 200;
        milk -= 100;
        coffeeBeans -= 12;
        money += 6;
        cups -= 1;
        printCoffeeMachineState();
    }
}
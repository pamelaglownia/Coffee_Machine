package pl.glownia.pamela;

import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCups() {
        return cups;
    }

    public int getMoney() {
        return money;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    void run() {
        Scanner scan = new Scanner(System.in);
        printCoffeeMachineState();
        makeDecision(scan);
    }

    void printCoffeeMachineState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    void makeDecision(Scanner scan) {
        String decision;
        do {
            System.out.println("\nWrite action(buy, fill, take, remaining, exit): ");
            decision = scan.next();
            while (!(decision.equalsIgnoreCase(Actions.BUY.name()) || (decision.equalsIgnoreCase(Actions.FILL.name())) || (decision.equalsIgnoreCase(Actions.REMAINING.name())) || (decision.equalsIgnoreCase(Actions.TAKE.name())) || (decision.equalsIgnoreCase(Actions.EXIT.name())))) {
                System.out.println("Incorrect value. Try again:");
                decision = scan.next();
            }
            if (decision.equalsIgnoreCase(Actions.BUY.name())) {
                Order order = new Order();
                order.chooseCoffee(this);
            } else if (decision.equalsIgnoreCase(Actions.FILL.name())) {
                RefillingIngredients filling = new RefillingIngredients();
                filling.fillCoffeeMachine(this);
            } else if (decision.equalsIgnoreCase(Actions.TAKE.name())) {
                System.out.println("I take $" + money + " from the coffee machine.");
                setMoney(0);
            } else if (decision.equalsIgnoreCase(Actions.REMAINING.name())) {
                printCoffeeMachineState();
            }
        } while (!(decision.equalsIgnoreCase(Actions.EXIT.name())));
        System.out.println("Thank you! Bye!");
    }
}
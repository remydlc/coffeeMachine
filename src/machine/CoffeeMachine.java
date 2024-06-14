package machine;
import java.util.Scanner;

public class CoffeeMachine {
    static int coffeeWater  = 400;
    static int coffeeMilk = 540;
    static int coffeeBeans = 120;
    static final int espressoCost  = 4;
    static final int latteCost = 7;
    static final int cappuccinoCost = 6;
    static int machineMoney = 550;
    static int cups = 9;
    static final int espressoWater = 250;
    static final int espressoBeans = 16;
    static final int latteWater = 350;
    static final int latteMilk = 75;
    static final int latteBeans = 20;
    static final int cappuccinoWater = 200;
    static final int cappuccinoMilk = 100;
    static final int cappuccinoBeans = 12;
    static Scanner getOrder = new Scanner(System.in);

    public static void printMachineStatus(){
        System.out.println("The coffee machine has:");
        System.out.println(coffeeWater + " ml of water");
        System.out.println(coffeeMilk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$"+machineMoney + " of money");
    }

    public static boolean calculate(int water, int milk, int beans, int cups) {
        if (water - coffeeWater >= 0 && milk - coffeeMilk >= 0 && beans - coffeeBeans >= 0 && cups > 0) {
            return true;
        }else {
            return false;
        }
    }

    public static void buy (int coffeeType) {
        if (coffeeType == 1) {
            if (coffeeWater - espressoWater >= 0 && coffeeBeans - espressoBeans >= 0 && cups > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                espresso();
            }else {
                System.out.println("Not enough resources");
                //takeOrder();
            }
        }
        else if (coffeeType == 2) {
            if (coffeeWater - latteWater >= 0 && coffeeMilk - latteMilk >= 0 && coffeeBeans - latteBeans >= 0 && cups > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                latte();
            }else {
                System.out.println("Not enough resources");
                //takeOrder();
            }
        } else if (coffeeType == 3){
            if (coffeeWater - cappuccinoWater >= 0 && coffeeMilk - cappuccinoMilk >= 0 && coffeeBeans - cappuccinoBeans >= 0 && cups > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                cappuccino();
            }else {
                System.out.println("Not enough resources");
                //takeOrder();
            }
        } else {
            System.out.println("Not a valid option");
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        coffeeWater += getOrder.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        coffeeMilk += getOrder.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += getOrder.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups += getOrder.nextInt();
    }
    public static void take() {
        // If the user writes "take" the program should give all the money that it earned from selling coffee.
        System.out.println("I gave you $" + machineMoney + "\n");
        machineMoney -= machineMoney;
    }
    public static void espresso() {
        coffeeWater -= espressoWater;
        coffeeBeans -= espressoBeans;
        machineMoney += espressoCost;
        cups --;
    }
    public static void latte() {
        coffeeWater -= latteWater;
        coffeeMilk -= latteMilk;
        coffeeBeans -= latteBeans;
        machineMoney += latteCost;
        cups --;
    }
    public static void cappuccino() {
        coffeeWater -= cappuccinoWater;
        coffeeMilk -= cappuccinoMilk;
        coffeeBeans -= cappuccinoBeans;
        machineMoney += cappuccinoCost;
        cups --;
    }
}

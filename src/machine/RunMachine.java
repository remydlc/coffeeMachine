package machine;


import static machine.CoffeeMachine.*;
import java.util.Scanner;

public class RunMachine {
    static Scanner getOrder = new Scanner(System.in);

    public static void main(String[] args) {
        MachineState machineState = MachineState.INITIAL;

        while (!machineState.equals(MachineState.EXIT)){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = getOrder.next();
            switch(action) {
                case "buy" -> machineState = MachineState.BUY;
                case "fill" -> machineState = MachineState.FILL;
                case "take" -> machineState = MachineState.TAKE;
                case "remaining" -> machineState = MachineState.REMAINING;
                case "exit" -> machineState = MachineState.EXIT;
                default -> throw new IllegalStateException("Invalid option: " + action);
            }

            if (machineState.equals(MachineState.BUY)) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu ");
                String coffeeType = getOrder.next();
                switch (coffeeType) {
                    case "1":
                    case "2":
                    case "3":
                        buy(Integer.parseInt(coffeeType));
                        break;
                    case "back":
                        machineState = MachineState.INITIAL;
                        break;
                }
            } else if (machineState.equals(MachineState.TAKE)) {
                take();

            } else if (machineState.equals(MachineState.FILL)) {
                fill();
            } else if (machineState.equals(MachineState.REMAINING)) {
                printMachineStatus();
            }

        }
    }

    public static void takeOrder(MachineState machineState) {
        System.out.println(machineState.name());
           }
    }

package main.java.com.cashregister;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();
        Cashier cashier = new Cashier(cashRegister);

        System.out.println("ready");

        handleInterface(cashier);
    }

    private static void handleInterface(Cashier cashier) {
        try (Scanner input = new Scanner(System.in)) {
            while (input.hasNextLine()) {
                String command = input.next();
                switch (command) {
                    case "show":
                        System.out.println(cashier.show());
                        break;
                    case "put":
                        System.out.println(cashier.put(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt()));
                        break;
                    case "take":
                        System.out.println(cashier.take(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt()));
                        break;
                    case "change":
                        System.out.println(cashier.change(input.nextInt()));
                        break;
                    case "quit":
                        System.out.println("Bye");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please enter valid action. | show | put | take | change | quit |");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
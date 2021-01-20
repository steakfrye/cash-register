package main.java.com.cashregister;

public class App {
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();
        Cashier cashier = new Cashier(cashRegister);

        try {
            switch (args[0]) {
                case "show":
                    System.out.println(cashier.show());
                    break;
                case "put":
                    System.out.println(cashier.put(args[1], args[2], args[3], args[4], args[5]));
                    break;
                case "take":
                    System.out.println(cashier.take(args[1], args[2], args[3], args[4], args[5]));
                    break;
                case "change":
                    System.out.println(cashier.change(args[1]));
                    break;
                case "quit":
                    System.out.println(cashier.quit());
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid argument(s)");
            }
        } catch (Exception e) {
            System.out.println("Invalid argument(s)");
        }
    }
}
package main.java.com.cashregister;

public class Cashier {
    private final CashRegister cashRegister;

    public Cashier(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
    }

    public String show() {
        return String.format("$%s %s %s %s %s %s",
                cashRegister.getTotal(),
                cashRegister.getTwenties(),
                cashRegister.getTens(),
                cashRegister.getFives(),
                cashRegister.getTwos(),
                cashRegister.getOnes());
    }

    public String put(String twenties, String tens, String fives, String twos, String ones) {
        cashRegister.setTwenties(cashRegister.getTwenties() + Integer.parseInt(twenties))
                .setTens(cashRegister.getTens() + Integer.parseInt(tens))
                .setFives(cashRegister.getFives() + Integer.parseInt(fives))
                .setTwos(cashRegister.getTwos() + Integer.parseInt(twos))
                .setOnes(cashRegister.getOnes() + Integer.parseInt(ones));

        return show();
    }

    public String take(String twenties, String tens, String fives, String twos, String ones) throws Exception {
        cashRegister.setTwenties(subtractBills(cashRegister.getTwenties(), Integer.parseInt(twenties)))
                .setTens(subtractBills(cashRegister.getTens(), Integer.parseInt(tens)))
                .setFives(subtractBills(cashRegister.getFives(), Integer.parseInt(fives)))
                .setTwos(subtractBills(cashRegister.getTwos(), Integer.parseInt(twos)))
                .setOnes(subtractBills(cashRegister.getOnes(), Integer.parseInt(ones)));

        return show();
    }

    public String change(String change) {

        return String.format("$%s %s %s %s %s");
    }

    public String quit() {
        return "Bye";
    }

    private int subtractBills(int existingBills, int billsToBeWithdrawn) throws Exception {
        int remainingBills = existingBills - billsToBeWithdrawn;
        if (remainingBills < 0) {
            throw new Exception("sorry");
        }
        return remainingBills;
    }
}

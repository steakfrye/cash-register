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

    public String take(String twenties, String tens, String fives, String twos, String ones) {
        try {
            cashRegister.setTwenties(subtractBills(cashRegister.getTwenties(), Integer.parseInt(twenties)))
                    .setTens(subtractBills(cashRegister.getTens(), Integer.parseInt(tens)))
                    .setFives(subtractBills(cashRegister.getFives(), Integer.parseInt(fives)))
                    .setTwos(subtractBills(cashRegister.getTwos(), Integer.parseInt(twos)))
                    .setOnes(subtractBills(cashRegister.getOnes(), Integer.parseInt(ones)));
        } catch (NullPointerException exception) {
            return "sorry";
        }
        return show();
    }

    public String change(String change) {
        int changeRemaining = Integer.parseInt(change);
        int twenties = 0;
        int tens = 0;
        int fives = 0;
        int twos = 0;
        int ones = 0;

        if (changeRemaining < cashRegister.getTotal()) {
            while (cashRegister.getTwenties() != 0 && changeRemaining >= 20) {
                cashRegister.setTwenties(cashRegister.getTwenties() - 1);
                changeRemaining -= 20;
                twenties += 1;
            }
            while (cashRegister.getTens() != 0 && changeRemaining >= 10) {
                cashRegister.setTens(cashRegister.getTens() - 1);
                changeRemaining -= 10;
                tens += 1;
            }
            while (cashRegister.getFives() != 0 && changeRemaining >= 5) {
                cashRegister.setFives(cashRegister.getFives() - 1);
                changeRemaining -= 5;
                fives += 1;
            }
            while (cashRegister.getTwos() != 0 && changeRemaining >= 2) {
                cashRegister.setTwos(cashRegister.getTwos() - 1);
                changeRemaining -= 2;
                twos += 1;
            }
            while (cashRegister.getOnes() != 0 && changeRemaining >= 1) {
                cashRegister.setOnes(cashRegister.getOnes() - 1);
                changeRemaining -= 1;
                ones += 1;
            }
            if (changeRemaining == 0) {
                return String.format("%s %s %s %s %s", twenties, tens, fives, twos, ones);
            }
        }
        return "sorry";
    }

    public String quit() {
        return "Bye";
    }

    private Integer subtractBills(int existingBills, int billsToBeWithdrawn) {
        int remainingBills = existingBills - billsToBeWithdrawn;
        if (remainingBills < 0) {
            return null;
        }
        return remainingBills;
    }
}

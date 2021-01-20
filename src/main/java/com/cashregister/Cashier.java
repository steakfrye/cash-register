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

    public String put(int twenties, int tens, int fives, int twos, int ones) {
        cashRegister.setTwenties(cashRegister.getTwenties() + twenties)
                .setTens(cashRegister.getTens() + tens)
                .setFives(cashRegister.getFives() + fives)
                .setTwos(cashRegister.getTwos() + twos)
                .setOnes(cashRegister.getOnes() + ones);

        return show();
    }

    public String take(int twenties, int tens, int fives, int twos, int ones) {
        try {
            cashRegister.setTwenties(subtractBills(cashRegister.getTwenties(), twenties))
                    .setTens(subtractBills(cashRegister.getTens(), tens))
                    .setFives(subtractBills(cashRegister.getFives(), fives))
                    .setTwos(subtractBills(cashRegister.getTwos(), twos))
                    .setOnes(subtractBills(cashRegister.getOnes(), ones));
        } catch (NullPointerException exception) {
            return "sorry";
        }
        return show();
    }

    public String change(int change) {
        int twentiesReturned = 0;
        int tensReturned = 0;
        int fivesReturned = 0;
        int twosReturned = 0;
        int onesReturned = 0;

        if (change < cashRegister.getTotal()) {
            while (cashRegister.getTwenties() != 0 && change >= 20) {
                cashRegister.setTwenties(cashRegister.getTwenties() - 1);
                change -= 20;
                twentiesReturned += 1;
            }
            while (cashRegister.getTens() != 0 && change >= 10) {
                cashRegister.setTens(cashRegister.getTens() - 1);
                change -= 10;
                tensReturned += 1;
            }
            while (cashRegister.getFives() != 0 && change >= 5) {
                cashRegister.setFives(cashRegister.getFives() - 1);
                change -= 5;
                fivesReturned += 1;
            }
            while (cashRegister.getTwos() != 0 && change >= 2) {
                cashRegister.setTwos(cashRegister.getTwos() - 1);
                change -= 2;
                twosReturned += 1;
            }
            while (cashRegister.getOnes() != 0 && change >= 1) {
                cashRegister.setOnes(cashRegister.getOnes() - 1);
                change -= 1;
                onesReturned += 1;
            }

            if (change == 0) {
                return String.format("%s %s %s %s %s", twentiesReturned, tensReturned, fivesReturned, twosReturned, onesReturned);
            }
        }
        return "sorry";
    }

    private Integer subtractBills(int existingBills, int billsToBeWithdrawn) {
        int remainingBills = existingBills - billsToBeWithdrawn;
        if (remainingBills < 0) {
            return null;
        }
        return remainingBills;
    }
}

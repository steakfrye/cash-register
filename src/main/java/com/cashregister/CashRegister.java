package main.java.com.cashregister;

public class CashRegister {
    private int ones;
    private int twos;
    private int fives;
    private int tens;
    private int twenties;

    public int getTotal() {
        return ones + (2 * twos) + (5 * fives) + (10 * tens) + (20 * twenties);
    }

    public int getOnes() {
        return ones;
    }

    public CashRegister setOnes(int ones) {
        this.ones = ones;
        return this;
    }

    public int getTwos() {
        return twos;
    }

    public CashRegister setTwos(int twos) {
        this.twos = twos;
        return this;
    }

    public int getFives() {
        return fives;
    }

    public CashRegister setFives(int fives) {
        this.fives = fives;
        return this;
    }

    public int getTens() {
        return tens;
    }

    public CashRegister setTens(int tens) {
        this.tens = tens;
        return this;
    }

    public int getTwenties() {
        return twenties;
    }

    public CashRegister setTwenties(int twenties) {
        this.twenties = twenties;
        return this;
    }
}
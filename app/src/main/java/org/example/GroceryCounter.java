package org.example;

public class GroceryCounter {
    private int count;
    private int overflowCount;

    public GroceryCounter() {
        this.count = 0;
        this.overflowCount = 0;
    }

    public void tens() {
        increment(1000);
    }

    public void ones() {
        increment(100);
    }

    public void tenths() {
        increment(10);
    }

    public void hundreths() {
        increment(1);
    }

    private void increment(int value) {
        count += value;
        if (count > 9999) {
            count = count % 10000;
            overflowCount++;
        }
    }

    public String total() {
        int dollars = count / 100;
        int cents = count % 100;
        return String.format("$%d.%02d", dollars, cents);
    }

    public int overflows() {
        return overflowCount;
    }

    public void clear() {
        count = 0;
        overflowCount = 0;
    }
}

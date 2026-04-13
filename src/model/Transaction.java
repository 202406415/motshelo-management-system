package model;

public abstract class Transaction {
    private double amount;
    private String date;

    public Transaction(double amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public abstract void display();
}
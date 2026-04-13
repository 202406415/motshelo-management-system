package model;

public class Member {
    private String name;
    private String phone;
    private double balance;
    private double loanBalance;

    public Member(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.balance = 0;
        this.loanBalance = 0;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getLoanBalance() {
        return loanBalance;
    }

    public void addContribution(double amount) {
        balance += amount;
    }

    public void receivePayout(double amount) {
        balance -= amount;
    }

    public void borrowMoney(double amount) {
        loanBalance += amount;
    }

    public void repayLoan(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (amount > loanBalance) {
            System.out.println("Cannot repay more than loan!");
            return;
        }

        loanBalance -= amount;
    }

    public void display() {
        System.out.println("Name: " + name +
                ", Balance: " + balance +
                ", Loan: " + loanBalance);
    }
}
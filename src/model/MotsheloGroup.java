package model;

import java.util.ArrayList;

public class MotsheloGroup {
    private String groupName;
    private ArrayList<Member> members;
    private ArrayList<Transaction> transactions;

    public MotsheloGroup(String groupName) {
        this.groupName = groupName;
        this.members = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public double getTotalFunds() {
        double total = 0;

        for (Transaction t : transactions) {
            if (t instanceof Contribution || t instanceof Repayment) {
                total += t.getAmount();
            } else if (t instanceof Payout || t instanceof Borrow) {
                total -= t.getAmount();
            }
        }

        return total;
    }

    public void generateReport() {
        System.out.println("\n--- Transactions Report ---");

        for (Transaction t : transactions) {
            t.display(); // polymorphism
        }

        System.out.println("Total Funds: " + getTotalFunds());
    }
}
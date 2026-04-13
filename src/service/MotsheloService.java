package service;

import model.*;

import java.util.Scanner;

public class MotsheloService {
    private MotsheloGroup group;
    private Scanner scanner;

    public MotsheloService(MotsheloGroup group) {
        this.group = group;
        this.scanner = new Scanner(System.in);
    }

    public void registerMember() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        group.addMember(new Member(name, phone));
        System.out.println("Member added!");
    }

    private Member findMember(String name) {
        for (Member m : group.getMembers()) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public void recordContribution() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        Member m = findMember(name);
        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        m.addContribution(amount);
        group.addTransaction(new Contribution(amount, "today", m));

        System.out.println("Contribution recorded!");
    }

    public void allocatePayout() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        Member m = findMember(name);
        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        double amount = group.getTotalFunds();

        if (amount <= 0) {
            System.out.println("No funds available!");
            return;
        }

        m.receivePayout(amount);
        group.addTransaction(new Payout(amount, "today", m));

        System.out.println("Payout done!");
    }

    public void borrowMoney() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        Member m = findMember(name);
        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (amount > group.getTotalFunds()) {
            System.out.println("Not enough funds in group!");
            return;
        }

        m.borrowMoney(amount);
        group.addTransaction(new Borrow(amount, "today", m));

        System.out.println("Borrow recorded!");
    }

    public void repayLoan() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        Member m = findMember(name);
        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        if (m.getLoanBalance() <= 0) {
            System.out.println("No loan to repay!");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (amount > m.getLoanBalance()) {
            System.out.println("Cannot repay more than loan!");
            return;
        }

        m.repayLoan(amount);
        group.addTransaction(new Repayment(amount, "today", m));

        System.out.println("Repayment recorded!");
    }

    public void viewMembers() {
        for (Member m : group.getMembers()) {
            m.display();
        }
    }

    public void viewReport() {
        group.generateReport();
    }
}
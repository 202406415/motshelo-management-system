package model;

public class Borrow extends Transaction {
    private Member borrower;

    public Borrow(double amount, String date, Member borrower) {
        super(amount, date);
        this.borrower = borrower;
    }

    public Member getBorrower() {
        return borrower;
    }

    @Override
    public void display() {
        System.out.println("Borrow: " + borrower.getName() +
                " borrowed " + getAmount() + " on " + getDate());
    }
}
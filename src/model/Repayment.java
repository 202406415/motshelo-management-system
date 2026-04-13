package model;

public class Repayment extends Transaction {
    private Member member;

    public Repayment(double amount, String date, Member member) {
        super(amount, date);
        this.member = member;
    }

    @Override
    public void display() {
        System.out.println("Repayment: " + member.getName() +
                " repaid " + getAmount() + " on " + getDate());
    }
}
package model;

public class Contribution extends Transaction {
    private Member member;

    public Contribution(double amount, String date, Member member) {
        super(amount, date);
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

    @Override
    public void display() {
        System.out.println("Contribution: " + member.getName() +
                " paid " + getAmount() + " on " + getDate());
    }
}
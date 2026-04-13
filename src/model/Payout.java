package model;

public class Payout extends Transaction {
    private Member receiver;

    public Payout(double amount, String date, Member receiver) {
        super(amount, date);
        this.receiver = receiver;
    }

    public Member getReceiver() {
        return receiver;
    }

    @Override
    public void display() {
        System.out.println("Payout: " + receiver.getName() +
                " received " + getAmount() + " on " + getDate());
    }
}
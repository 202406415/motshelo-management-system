package app;

import model.MotsheloGroup;
import service.MotsheloService;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MotsheloGroup group = new MotsheloGroup("My Motshelo");
        MotsheloService service = new MotsheloService(group);

        int choice;

        do {
            System.out.println("\n==== MOTSHELO SYSTEM ====");
            System.out.println("1. Add Member");
            System.out.println("2. Record Contribution");
            System.out.println("3. Allocate Payout");
            System.out.println("4. Borrow Money");
            System.out.println("5. Repay Loan");
            System.out.println("6. View Members");
            System.out.println("7. View Report");
            System.out.println("8. Exit");

            System.out.print("Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> service.registerMember();
                case 2 -> service.recordContribution();
                case 3 -> service.allocatePayout();
                case 4 -> service.borrowMoney();
                case 5 -> service.repayLoan();
                case 6 -> service.viewMembers();
                case 7 -> service.viewReport();
                case 8 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 8);
    }
}
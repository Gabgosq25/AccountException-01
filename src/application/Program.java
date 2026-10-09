package application;


import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter account number: ");
            int number = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            System.out.print("Enter account holder: ");
            String holder = sc.nextLine();
            System.out.print("Enter initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Enter withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);

            System.out.print(account);
        } catch (IllegalArgumentException e) {
            System.out.println("Conflicting data; please enter the requested information.\n" + e.getMessage());
        } catch (DomainException e) {
            System.out.println("Unexpected error: \n" + e.getMessage());
        }

        sc.close();

    }
}

package com.bank.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Bank> accounts = new ArrayList<>();
        Bank currentAccount = null;

        System.out.println("Welcome to the Bank Management System");

        int choice;
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create New Account");
            System.out.println("2. Select Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new account number: ");
                    String accNo = sc.nextLine();

                    // Check if account number already exists
                    boolean exists = false;
                    for (Bank acc : accounts) {
                        if (acc.getAccountNumber().equals(accNo)) {
                            System.out.println("Account number already exists!");
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        Bank newAccount = new Bank(name, accNo);
                        accounts.add(newAccount);
                        System.out.println("Account created successfully!");
                    }
                    break;

                case 2:
                    System.out.print("Enter account number to select: ");
                    String selectAccNo = sc.nextLine();
                    currentAccount = null;
                    for (Bank acc : accounts) {
                        if (acc.getAccountNumber().equals(selectAccNo)) {
                            currentAccount = acc;
                            break;
                        }
                    }
                    if (currentAccount != null) {
                        System.out.println("Account selected: " + currentAccount.getAccountHolder());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    if (currentAccount == null) {
                        System.out.println("Please select an account first!");
                        break;
                    }
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = sc.nextDouble();
                    currentAccount.deposit(depositAmt);
                    break;

                case 4:
                    if (currentAccount == null) {
                        System.out.println("Please select an account first!");
                        break;
                    }
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = sc.nextDouble();
                    currentAccount.withdraw(withdrawAmt);
                    break;

                case 5:
                    if (currentAccount == null) {
                        System.out.println("Please select an account first!");
                        break;
                    }
                    currentAccount.checkBalance();
                    break;

                case 6:
                    if (currentAccount == null) {
                        System.out.println("Please select an account first!");
                        break;
                    }
                    currentAccount.printTransactionHistory();
                    break;

                case 7:
                    System.out.println("Thank you. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 7);

        sc.close();
    }
}

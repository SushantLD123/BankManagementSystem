package com.bank.app;

import java.util.ArrayList;

public class Bank {
    private String name;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Bank(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance $0.0");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: $" + amount);
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public String getAccountHolder() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction History for account " + accountNumber + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

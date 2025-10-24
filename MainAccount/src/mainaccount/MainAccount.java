/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainaccount;

/**
 *
 * @author Carla Mae
 */
import java.util.ArrayList;
import java.util.Scanner;

// Account class
class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Successfully deposited ₱" + amount);
        } else {
            System.out.println("⚠️ Deposit amount must be positive!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("💸 Successfully withdrew ₱" + amount);
        } else if (amount > balance) {
            System.out.println("⚠️ Insufficient balance!");
        } else {
            System.out.println("⚠️ Invalid withdrawal amount!");
        }
    }

    // Display account details
    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber +
                           " | Holder: " + accountHolder +
                           " | Balance: ₱" + balance);
    }
}

// Bank class
class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    // Add new account
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("🏦 Account added successfully!");
    }

    // Remove account by account number
    public void removeAccount(String accountNumber) {
        boolean found = false;
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                accounts.remove(acc);
                System.out.println("❌ Account removed successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("⚠️ Account not found!");
        }
    }

    // Find account by account number
    private Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    // Deposit into account
    public void depositToAccount(String accountNumber, double amount) {
        Account acc = findAccount(accountNumber);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("⚠️ Account not found!");
        }
    }

    // Withdraw from account
    public void withdrawFromAccount(String accountNumber, double amount) {
        Account acc = findAccount(accountNumber);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("⚠️ Account not found!");
        }
    }

    // Display all accounts
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("📭 No accounts available.");
        } else {
            System.out.println("\n=== All Bank Accounts ===");
            for (Account acc : accounts) {
                acc.displayAccount();
            }
        }
    }
}

// Main class
public class MainAccount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();
        int choice;

        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Account");
            System.out.println("2. Remove Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum = input.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = input.nextDouble();

                    Account newAcc = new Account(accNum, name, balance);
                    bank.addAccount(newAcc);
                    break;

                case 2:
                    System.out.print("Enter Account Number to Remove: ");
                    String removeNum = input.nextLine();
                    bank.removeAccount(removeNum);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String depNum = input.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    double depAmt = input.nextDouble();
                    bank.depositToAccount(depNum, depAmt);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String witNum = input.nextLine();
                    System.out.print("Enter Amount to Withdraw: ");
                    double witAmt = input.nextDouble();
                    bank.withdrawFromAccount(witNum, witAmt);
                    break;

                case 5:
                    bank.displayAllAccounts();
                    break;

                case 6:
                    System.out.println("👋 Thank you for using the Bank System!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        } while (choice != 6);

        input.close();
    }
}
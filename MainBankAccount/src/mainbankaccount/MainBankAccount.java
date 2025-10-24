/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainbankaccount;

/**
 *
 * @author Carla Mae
 */
import java.util.Scanner;

class BankAccount {
    // Attributes
    private String accountNumber;
    private String accountHolder;
    protected double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: ₱" + amount);
        } else {
            System.out.println("⚠️ Invalid amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("💸 Withdrawn: ₱" + amount);
        } else {
            System.out.println("⚠️ Insufficient balance or invalid amount!");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("💰 Current Balance: ₱" + balance);
    }

    // Method to display account info
    public void displayInfo() {
        System.out.println("\n🏦 Account Information:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₱" + balance);
    }
}

// Subclass extending BankAccount
class SavingsAccount extends BankAccount {
    private double interestRate; // in percent

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Method to apply interest
    public void applyInterest() {
        double interest = (balance * interestRate) / 100;
        balance += interest;
        System.out.println("🏦 Interest applied: ₱" + String.format("%.2f", interest));
        System.out.println("New balance: ₱" + String.format("%.2f", balance));
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class MainBankAccount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create a savings account
        System.out.print("Enter Account Number: ");
        String accNum = input.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String holder = input.nextLine();
        System.out.print("Enter Initial Balance: ₱");
        double balance = input.nextDouble();
        System.out.print("Enter Interest Rate (%): ");
        double rate = input.nextDouble();

        SavingsAccount account = new SavingsAccount(accNum, holder, balance, rate);

        int choice;
        do {
            System.out.println("\n===== BANK ACCOUNT MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Apply Interest");
            System.out.println("5. Display Account Info");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₱");
                    double dep = input.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ₱");
                    double wit = input.nextDouble();
                    account.withdraw(wit);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.applyInterest();
                    break;

                case 5:
                    account.displayInfo();
                    break;

                case 6:
                    System.out.println("🏧 Exiting... Thank you!");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice, please try again.");
            }

        } while (choice != 6);

        input.close();
    }
}
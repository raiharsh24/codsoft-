import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            System.out.println("Invalid deposit amount.");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.println("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (userAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance: Rs." + userAccount.checkBalance());
                    } else {
                        System.out.println("Withdrawal failed.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (userAccount.deposit(depositAmount)) {
                        System.out.println("Deposit successful. New balance: Rs." + userAccount.checkBalance());
                    } else {
                        System.out.println("Deposit failed.");
                    }
                    break;

                case 3:
                    System.out.println("Current balance: Rs." + userAccount.checkBalance());
                    break;

                case 4:
                    System.out.println("Exiting the ATM. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}

public class atminterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000);  //present balance
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
class Account {
    import java.util.ArrayList;

public class Account {
    String name;
    int accountNumber;
    double balance;
    ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("Amount Deposited Successfully!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else if (amount > 0) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
            System.out.println("Amount Withdrawn Successfully!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No Transactions Yet.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}

}

 class Transaction{
public class Transaction {
    String type;
    double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String toString() {
        return type + " : ₹" + amount;
    }
}
    
}

public class BankingInformationSystem {
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Welcome to Digital Bank =====");

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Account account = new Account(name, accNo, balance);

        int choice;

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Amount to Deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter Amount to Withdraw: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.showTransactions();
                    break;

                case 5:
                    System.out.println("Thank You for Using Digital Bank!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
    
}
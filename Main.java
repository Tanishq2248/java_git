
class BankAccount {
    public String accountNumber;
    public String accountHolderName;
    public double balance;

    public BankAccount(String accountNumber, String accountHolderName, double openingBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = Math.max(0.0, openingBalance);
        if (openingBalance < 0.0) {
            System.out.println("Opening balance cannot be negative");
        }
    }

    public void deposit(double amount) {
        if (amount <= 0.0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0.0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance in account " + accountNumber + ". Withdrawal declined.");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance for account:- " + balance );
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("1001", "Aarav Sharma", 1000.00);
        BankAccount account2 = new BankAccount("1002", "Mira Patel", 500.00);

        System.out.println("=== Account 1 transactions ===");
        account1.deposit(250.00);
        account1.withdraw(100.00);
        account1.withdraw(2000.00); 

        System.out.println("=== Account 2 transactions ===");
        account2.deposit(150.00);
        account2.withdraw(75.00);

        System.out.println("=== Final account details ===");
        System.out.println("Account 1:");
        account1.displayDetails();
        account1.checkBalance();

        System.out.println("Account 2:");
        account2.displayDetails();
        account2.checkBalance();
    }
}

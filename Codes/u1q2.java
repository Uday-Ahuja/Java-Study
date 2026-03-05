class BankAccount {
    // Private data members - encapsulation
    private String accountNumber;
    private double balance;
    
    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    // Public getter for balance (read-only access)
    public double getBalance() {
        return balance;
    }
    
    // Public getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }
    
    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
            System.out.println("New Balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    // Public method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
            System.out.println("New Balance: ₹" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
    
    // Display account details
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

public class u1q2 {
    public static void main(String[] args) {
        // Create account
        BankAccount account = new BankAccount("ACC123456", 5000.0);
        
        // Display initial details
        account.displayAccountDetails();
        
        // Deposit operation
        System.out.println("\n--- Deposit Operation ---");
        account.deposit(2000);
        
        // Withdrawal operation - valid
        System.out.println("\n--- Withdrawal Operation ---");
        account.withdraw(1500);
        
        // Withdrawal operation - insufficient balance
        System.out.println("\n--- Withdrawal Operation ---");
        account.withdraw(10000);
        
        // Display final details
        account.displayAccountDetails();
        
        // Attempting direct access (will cause error if uncommented)
        // account.balance = 100000;  // ❌ ERROR: balance has private access
        
        // Correct way - using public methods only
        System.out.println("\nCurrent Balance: ₹" + account.getBalance());
    }
}
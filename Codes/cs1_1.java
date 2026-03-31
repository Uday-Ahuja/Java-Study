class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double calculateInterest() {
        return balance * 0.02;
    }
}

class SavingsAccount extends Account {

    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public double calculateInterest() {
        double interest = balance * 0.04;

        if (balance > 50000) {
            interest += 500; // Loyalty bonus
        }

        return interest;
    }
}

class FixedDeposit extends SavingsAccount {

    public FixedDeposit(double balance) {
        super(balance);
    }

    @Override
    public double calculateInterest() {
        double baseInterest = super.calculateInterest();
        double extraInterest = balance * 0.02;

        return baseInterest + extraInterest;
    }
}
public class cs1_1 {
    public static void main(String[] args) {

        Account a1 = new SavingsAccount(10000);
        System.out.println(a1.calculateInterest()); // 400

        Account a2 = new SavingsAccount(60000);
        System.out.println(a2.calculateInterest()); // 2900

        Account a3 = new FixedDeposit(60000);
        System.out.println(a3.calculateInterest()); // 4100
    }
}
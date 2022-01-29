package BankAccount;

public class BankAccount {
    public static int nextAccountId = 1;
    public int id;
    public double balance;
    public static double interestRate = 0.02;

    public BankAccount() {
        this.id = nextAccountId;
        nextAccountId++;
    }

    public double getInterestRate(int years) {
        return interestRate * years * balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double depositSum){
        this.balance += depositSum;
    }
}

public class SavingAccount {

    private final int accountNumber;
    private static int totalNumberOfAccounts = 0;
    private double balance;

    private double interestRate;






    /**
     * A saving account has a balance that can be changed by deposits and withdrawals.
     */
    public SavingAccount (double interestRate) {
        totalNumberOfAccounts++;
        accountNumber = totalNumberOfAccounts;
        balance = 0;
        this.interestRate = interestRate;
    }

    public SavingAccount(double initialBalance, double interestRate) {
        totalNumberOfAccounts++;
        accountNumber = totalNumberOfAccounts;
        balance = initialBalance;
        this.interestRate = interestRate;
    }

    /**
     * Deposit money to the bank account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        balance = balance + amount;
    }

    /**
     * Withdraws money from the bank account.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    public void addInterest() {
        double interest = balance * interestRate * 90 / 36000;
        balance = balance + interest;
    }
    /**
     * Gets the number of the saving account.
     *
     * @return the account number
     */

    public void setInterestRate(double interestRate)
    {
        this.interestRate= interestRate;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the current balance of the saving account.
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    double getInterestRate() {
        return interestRate;
        }
}


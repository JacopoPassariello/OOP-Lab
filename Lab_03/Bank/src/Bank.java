import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(double initialBalance, String customerName) {
        BankAccount newAccount = new BankAccount(initialBalance,customerName);
        accounts.add(newAccount);
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount ba : this.accounts) {
            if (ba.getAccountNumber() == accountNumber)
                return ba;
        }
        return null;
    }

    public void deposit(int accountNumber, double amount) {
        for (BankAccount ba : this.accounts)
        {
            if(ba.getAccountNumber() == accountNumber)
                ba.deposit(amount);
        }
    }

    public void withdraw(int accountNumber, double amount) {
        for (BankAccount ba : this.accounts)
        {
            if (ba.getAccountNumber() == accountNumber)
                ba.withdraw(amount);
        }
    }

    public double getBalance(int accountNumber) {
            double b = 0;
            for (BankAccount ba : this.accounts)
            {
                if (ba.getAccountNumber() == accountNumber)
                    b = ba.getBalance();
            }
            return b;
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {

        if(fromAccountNumber == toAccountNumber) return;

        BankAccount fromAccount = find(fromAccountNumber);
        BankAccount toAccount = find(toAccountNumber);

        if(fromAccount == null || toAccount == null) return;

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}
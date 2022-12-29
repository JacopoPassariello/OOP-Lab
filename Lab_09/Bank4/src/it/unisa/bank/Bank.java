package it.unisa.bank;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bank {

    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount bankAccount) {
        this.accounts.add(bankAccount);
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount ba : this.accounts) {
            if (ba.getAccountNumber() == accountNumber)
                return ba;
        }
        return null;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account = this.find(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) {
        BankAccount account = this.find(accountNumber);
        account.withdraw(amount);
    }

    public double getBalance(int accountNumber) {
        BankAccount account = this.find(accountNumber);
        return account.getBalance();
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = this.find(fromAccountNumber);
        BankAccount toAccount = this.find(toAccountNumber);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        this.accounts = new ArrayList<BankAccount>();
        while(in.hasNextLine())
        {
            try
            {
                String accountLine = in.nextLine();
                String[] accountValues = accountLine.split(",");
                int accountNumber = Integer.parseInt(accountValues[0]);
                String accountName = accountValues[1];
                double accountBalance = Double.parseDouble(accountValues[2]);
                if(accountValues.length == 3)
                {
                    accounts.add(new BankAccount(accountNumber,accountName,accountBalance));
                }
                else
                {
                    double interestRate = Double.parseDouble(accountValues[3]);
                    accounts.add(new SavingAccount(accountNumber,accountName,accountBalance,interestRate));
                }
            } catch(NoSuchElementException | NumberFormatException e)
            {
                System.out.println("Formattazione File errata!");
            }
        }

    }

    public void writeUserDataToFile(File file, boolean overwrite) throws FileNotFoundException, FileAlreadyExistsException {
        if(!overwrite && file.exists()) throw new FileAlreadyExistsException("Il file già esiste!");
        else
        {
            writeUserDataToFile(file);
        }
        if(overwrite && !file.exists())
        {
            throw new FileNotFoundException("Il file da sovrascrivere non esiste!");
        }
        else
        {
            String temp = file.getParentFile().getName() + File.separator + "tmp_" + file.getName();
            File tmpFile = new File(temp);
            writeUserDataToFile(tmpFile);
            file.delete();
            tmpFile.renameTo(file);

        }
    }

    public void writeUserDataToFile(File file) throws FileNotFoundException
    {
        PrintWriter out = new PrintWriter(file);
        for(BankAccount account : accounts)
        {
            out.println(account.getAccountNumber());
            out.println(account.getBalance());
            out.println(account.getCustomerName());
        }
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        this.accounts = (List<BankAccount>) in.readObject();
        in.close();
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(this.accounts);
        out.close();
    }
}

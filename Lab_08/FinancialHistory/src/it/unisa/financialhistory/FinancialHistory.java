package it.unisa.financialhistory;

import java.util.ArrayList;
import java.util.List;

public class FinancialHistory {
    final private Person person;
    private double balance;
    final private List<Movement> movements;

    public FinancialHistory(Person person, double balance) {
        if(balance < 0)
        {
            throw new IllegalArgumentException("Balance cannot be negative!");
        }
        this.person = person;
        this.balance = balance;
        movements = new ArrayList<>();
    }

    public void receiveFrom(int amount, String source) {
        Movement m = new Movement(source,amount);
        this.movements.add(m);
        this.balance += amount;
    }

    public void spendFor(int amount, String reason) {
        if(amount > this.balance)
            throw new IllegalArgumentException("Amount requested cannot bigger than balance!");
        Movement m = new Movement(reason,-amount);
        movements.add(m);
        balance -= amount;
    }

    public double cashOnHand() {
        return balance;
    }


    public double totalReceivedFrom(String source) {
        double total = 0;
        for(Movement m : movements)
        {

            if(m.getDescription().equals(source) && m.getAmount() > 0)
                total += m.getAmount();

        }
        return total;
    }

    public double totalSpentFor(String reason) {
        double total = 0;
        for(Movement m : movements)
        {
            if(m.getDescription().equals(reason) && m.getAmount() < 0)
                total += m.getAmount();
        }
        return total;
    }

    public void printMovements() {
        for(Movement m : movements)
        {
            System.out.println(m.getDescription() + ":     " + m.getAmount() + "€" );

        }
    }

}

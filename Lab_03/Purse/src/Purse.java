import java.util.ArrayList;
import java.util.List;

public class Purse {

    /* TODO */

    private final List<Coin> coins;

    public Purse() {
        coins = new ArrayList<>();
    }

    public void add(Coin coin) {
        coins.add(coin);
    }

    public static Coin Dollar = new Coin("Dollar",1.00);
    public static Coin Quarter = new Coin("Quarter",0.25);
    public static Coin Dime = new Coin("Dime",0.10);
    public static Coin Nickel = new Coin("Nickel",0.05);
    public static Coin Cent = new Coin("Cent",0.01);


    public boolean find(Coin coin) {

        if (coins.isEmpty()) return false;
        for(Coin check : coins)
        {
            if(check.equals(coin))
                return true;
        }
        return false;
    }

    public int count(Coin coin) {
        int amount = 0;
        for(Coin check : coins)
        {
            if(check.equals(coin))
                amount++;
        }
        return amount;
    }

    public Coin getMinimum() {
        if (coins.isEmpty()) return null;

        Coin smallest = coins.get(0);
        for(Coin check : coins)
        {
            if(check.getValue()<smallest.getValue())
                smallest = check;
        }
        return smallest;
    }


    public Coin getMaximum() {
        if(coins.isEmpty()) return null;

        Coin biggest = coins.get(0);
        for(Coin check : coins)
        {
            if(check.getValue()>biggest.getValue())
                biggest = check;
        }
        return biggest;
    }

    public double getTotal() {
        double totalAmount = 0;
        for(Coin check : coins)
        {
            totalAmount += check.getValue();
        }
        return totalAmount;
    }

    public void remove(Coin coin) {
        coins.remove(coin);
    }

    public boolean hasCoin(Coin coin) {
        return coins.contains(coin);
    }

    @Override
    public String toString() {
        String output = "Purse[";
        output += "Dollar = " + this.count(Dollar);
        output += ", Quarter = " + this.count(Quarter);
        output += ", Dime = " + this.count(Dime);
        output += ", Nickel = " + this.count(Nickel);
        output += ", Cent = " + this.count(Cent) + "]";
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass() != getClass()) return false;
        if(this == o ) return true;
        Purse purse = (Purse) o;
        if(this.getTotal() == purse.getTotal())
        {
            return this.count(Dollar) == purse.count(Dollar)
                    && this.count(Quarter) == purse.count(Quarter)
                    && this.count(Dime) == purse.count(Dime)
                    && this.count(Nickel) == purse.count(Nickel)
                    && this.count(Cent) == purse.count(Cent);
        }
        return false;

    }
}
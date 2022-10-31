import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

    @Before
    public void setup(){
        BankAccount.totalNumberOfAccounts = 0;
    }

    @Test
    public void findAccountTest() {
        Bank b = new Bank();
        b.addAccount(1000, "Dario");
        BankAccount newAccount = b.find(1);
        Assert.assertEquals(1, newAccount.getAccountNumber());
        Assert.assertEquals(1000, newAccount.getBalance(), 0);
        Assert.assertEquals("Dario", newAccount.getCustomerName());
    }

    @Test
    public void depositTest() {
        Bank b = new Bank();
        b.addAccount(1000,"Joe Mama");
        b.deposit(1,1000);

        Assert.assertEquals(2000,b.getBalance(1),0);
    }

    @Test
    public void withdrawTest() {
        Bank b = new Bank();
        b.addAccount(1000,"Joe Mama");
        b.withdraw(1,1000);

        Assert.assertEquals(0,b.getBalance(1),0);
    }

    @Test
    public void transferTest() {
        Bank b = new Bank();
        b.addAccount(1000,"Joe Mama");
        b.addAccount(1000,"Pippo Pluto");
        b.transfer(1,2,1000);

        Assert.assertEquals(2000,b.getBalance(2),0);

        b.transfer(1,1,1000);
        Assert.assertEquals(0,b.getBalance(1),0);

        b.transfer(1,2,1000);
        Assert.assertEquals(-1000,b.getBalance(1),0);

        b.transfer(1,3,1000);
        Assert.assertEquals(-1000,b.getBalance(1),0);
    }
}
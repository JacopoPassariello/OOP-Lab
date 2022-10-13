import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest
{

    @Test
    public void newCansTest()
    {
        VendingMachine prova = new VendingMachine();

        prova.addCans(10);

        Assert.assertEquals(10,prova.getNumberOfCans(),0);

    }

    @Test
    public void takeCanTest()
    {
        VendingMachine prova = new VendingMachine();

        prova.addCans(10);

        prova.takeCan();

        Assert.assertEquals(9, prova.getNumberOfCans(),0);
    }

    @Test
    public void takeTokensTest()
    {
        VendingMachine prova = new VendingMachine();

        prova.addCans(10);

        for (int i=0; i<5;i++)
        {
            prova.takeCan();
        }

        Assert.assertEquals(5,prova.getNumberOfTokens(),0);
        prova.takeTokens();
        Assert.assertEquals(0,prova.getNumberOfTokens(),0);
    }



}
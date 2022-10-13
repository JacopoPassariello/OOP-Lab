import org.junit.Assert;
import org.junit.Test;

public class InfectedTest {

    @Test public void InfectedMethodTest()
    {
        Infected prova = new Infected("Codyceps",69);
        prova.addInfected(420);
        Assert.assertEquals(489,prova.getNumberOfInfected(),0);
        prova.updateInfectedByRt(5.2);
        Assert.assertEquals((int)(5.2*489),prova.getNumberOfInfected(),0);
    }
}
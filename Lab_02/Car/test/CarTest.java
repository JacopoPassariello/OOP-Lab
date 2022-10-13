import org.junit.Assert;
import org.junit.Test;

public class CarTest {
    @Test public void CarMethodTest()
    {
        Car pandino = new Car(0.25,50);
        pandino.addGas(30.5);
        Assert.assertEquals(80.5,pandino.getGas(),0);

        pandino.drive(100);
        Assert.assertEquals(55.5,pandino.getGas(),0);

    }
}
import org.junit.Assert;
import org.junit.Test;

public class PurseTest {

  @Test
  public void findTest()
  {
    Purse p = new Purse();
    p.add(Purse.Quarter);
    p.add(Purse.Dime);
    p.add(Purse.Nickel);
    Assert.assertTrue(p.find(Purse.Nickel));
  }

  @Test
  public void countTest() {
    Purse p = new Purse();
    p.add(Purse.Dollar);
    p.add(Purse.Dollar);
    p.add(Purse.Dollar);
    p.add(Purse.Nickel);
    Assert.assertEquals(3,p.count(Purse.Dollar),0);
  }

  @Test
  public void minMaxTest() {
    Purse p = new Purse();
    p.add(Purse.Nickel);
    p.add(Purse.Dollar);
    p.add(Purse.Dime);
    p.add(Purse.Cent);
    p.add(Purse.Quarter);

    Assert.assertTrue(Purse.Cent.equals(p.getMinimum()));
    Assert.assertTrue(Purse.Dollar.equals(p.getMaximum()));



  }

  @Test
  public void getTotalTest() {
    Purse p = new Purse();
    p.add(Purse.Nickel);
    p.add(Purse.Dollar);
    p.add(Purse.Dime);
    p.add(Purse.Cent);
    p.add(Purse.Quarter);

    Assert.assertEquals(1.41d,p.getTotal(),0.001);
  }

  @Test
  public void addRemoveTest() {
    Purse p = new Purse();
    p.add(Purse.Nickel);
    p.add(Purse.Dollar);
    p.add(Purse.Dime);
    p.add(Purse.Cent);
    p.add(Purse.Quarter);

    p.remove(p.Quarter);

    Assert.assertTrue(!p.find(Purse.Quarter));
  }

  @Test
  public void hasCoinTest() {
    Purse p = new Purse();
    p.add(Purse.Nickel);
    p.add(Purse.Dollar);
    p.add(Purse.Dime);
    p.add(Purse.Cent);
    p.add(Purse.Quarter);

    Assert.assertTrue(p.hasCoin(Purse.Quarter));

  }

  @Test
  public void toStringTest() {
    Purse p = new Purse();
    p.add(Purse.Nickel);
    p.add(Purse.Dollar);

    Assert.assertTrue("Purse[Dollar = 1, Quarter = 0, Dime = 0, Nickel = 1, Cent = 0]".equals(p.toString()));


  }

  @Test
  public void equalsTest() {
    Purse p = new Purse();
    p.add(Purse.Nickel);
    p.add(Purse.Dollar);
    p.add(Purse.Dime);
    p.add(Purse.Cent);
    p.add(Purse.Quarter);

    Purse b = new Purse();
    b.add(Purse.Nickel);
    b.add(Purse.Dollar);
    b.add(Purse.Dime);
    b.add(Purse.Cent);
    b.add(Purse.Quarter);

    Purse d = new Purse();

    Purse h = new Purse();
    h.add(Purse.Dollar);

    String c = "ciao";

    Assert.assertTrue(p.equals(b));
    Assert.assertFalse(p.equals(d));
    Assert.assertFalse(p.equals(h));
    Assert.assertFalse(p.equals(c));
  }
}
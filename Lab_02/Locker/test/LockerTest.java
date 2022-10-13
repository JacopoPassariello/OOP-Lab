import org.junit.Assert;
import org.junit.Test;

public class LockerTest {
    @Test public void TestLock()
    {
        Locker test = new Locker();
        test.newComb("123");
        test.lock();
        Assert.assertFalse(test.isOpen());

        test.unlock("456");
        Assert.assertFalse(test.isOpen());
        test.unlock("123");
        Assert.assertTrue(test.isOpen());

    }
}
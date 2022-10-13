import org.junit.Assert;
import org.junit.Test;

public class InputCheckerTest {
    @Test public void CheckInputChecker(){

        String[] array = {"S","SI","OK","certo","perché no?"};
        String[] array2 = {"No","N"};
        String dataError = "Hello, World!";
        InputChecker test = new InputChecker();
        for (String i: array )
        {
            Assert.assertEquals("OK",test.checkInput(i));
        }
        for(String i: array2)
        {
            Assert.assertEquals("Fine",test.checkInput(i));
        }

        Assert.assertEquals("Dato non corretto",test.checkInput(dataError));


    }
}
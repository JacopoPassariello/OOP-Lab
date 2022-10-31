import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

public class CarSellerTest {
    @Test
    public void findTest()
    {
        CarSeller test = new CarSeller();

        File file = Path.of("test/").resolve("testData.txt").toFile();
        try{
            test.getCarsFromFile(file);
            Assert.assertTrue(test.find("Tesla","Model S"));
            Assert.assertTrue(test.find("Tesla","Model Y",2020));
            Assert.assertTrue(test.find("Fiat","Punto",0,1));
            Assert.assertFalse(test.find("Mercedes-Benz","GLC",0,1));
        }catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
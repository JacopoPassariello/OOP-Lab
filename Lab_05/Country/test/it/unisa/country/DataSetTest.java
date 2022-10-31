package it.unisa.country;

import org.junit.Assert;
import org.junit.Test;

public class DataSetTest {
    @Test
    public void testMinimum() {
        DataSet x = new DataSet();
        Country a = new Country("Italia",60);
        Country b = new Country("Sacro Romano Impero",61);

        x.add(a);
        x.add(b);
        Assert.assertEquals("Italia",x.getMinimum().getName());
    }

    @Test
    public void testMaximum() {
        DataSet x = new DataSet();
        Country a = new Country("Italia",60);
        Country b = new Country("Sacro Romano Impero",61);

        x.add(a);
        x.add(b);
        Assert.assertEquals("Sacro Romano Impero",x.getMaximum().getName());
    }
}
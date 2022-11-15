package it.unisa.quiz;

import org.junit.Assert;
import org.junit.Test;

public class DataSetTest {
    @Test
    public void testMinimum() {
        DataSet n = new DataSet();
        Quiz a = new Quiz(1.0);
        Quiz b = new Quiz (2.0);
        Quiz c = new Quiz (3.0);
        n.add(a);
        n.add(b);
        n.add(c);
        Assert.assertEquals(1.0,n.getMinimum().getMeasure(),0);
    }

    @Test
    public void testMaximum() {
        DataSet n = new DataSet();
        Quiz a = new Quiz(1.0);
        Quiz b = new Quiz (2.0);
        Quiz c = new Quiz (3.0);
        n.add(a);
        n.add(b);
        n.add(c);
        Assert.assertEquals(3.0,n.getMaximum().getMeasure(),0);
    }

    @Test
    public void testAverage() {
        DataSet n = new DataSet();
        Quiz a = new Quiz(1.0);
        Quiz b = new Quiz (2.0);
        Quiz c = new Quiz (3.0);
        n.add(a);
        n.add(b);
        n.add(c);
        Assert.assertEquals(2.0,n.getAverage(),0);
    }
}
package it.unisa.school;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void toStringTest() {
        Person p = new Person("Alice", "Rossi", 1997, "aliros", "testPassword");
        Assert.assertEquals("Nome='Alice', Cognome='Rossi', Anno di nascita=1997",
                p.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void passwordTest() {
        Person p = new Person("Alice", "Rossi", 1997, "aliros", "t st");
    }

    @Test(expected = IllegalArgumentException.class)
    public void userIDTest(){
        Person p = new Person("Alice", "Rossi", 1997, "als", "testPassword");
    }

    @Test(expected = IllegalArgumentException.class)
    public void userNameTest(){
        Person p = new Person("", "Rossi", 1997, "als", "testPassword");
    }

    @Test(expected = IllegalArgumentException.class)
    public void userSurnameTest(){
        Person p = new Person("Alice", null, 1997, "als", "testPassword");
    }
}
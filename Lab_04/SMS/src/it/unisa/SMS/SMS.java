package it.unisa.SMS;

import java.util.GregorianCalendar;

public class SMS {

    private String sender;
    private GregorianCalendar date;
    private final int ID;
    private String text;
    private static int messageNumber = 0;

    public SMS (String sender,GregorianCalendar date,String Text)
    {
           this.sender = sender;
           this.date = date;
           this.ID = ++messageNumber;
    }

    public String getSender()
    {
        return sender;
    }

    public GregorianCalendar getDate()
    {
        return date;
    }
}





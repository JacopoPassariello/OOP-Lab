package SMS;

import java.util.Comparator;
import java.util.GregorianCalendar;

public class SMS {
    private final String sender;
    private final GregorianCalendar date;
    private final int id;
    private static int totalNumberSMS;
    private final String text;

    public SMS(String sender, GregorianCalendar date, String text) {
        this.sender = sender;
        this.date = date;
        this.text = text;
        this.id = totalNumberSMS;
        totalNumberSMS++;
    }

    public String getSender() {
        return sender;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public static int getTotalNumberSMS() {
        return totalNumberSMS;
    }

    public String getText() {
        return text;
    }

    public static Comparator<SMS> senderComparator = new Comparator<>(){
        @Override
                public int compare(SMS s1,SMS s2){
            return s1.getSender().compareTo(s2.getSender());
        }
    };

    public static Comparator<SMS> dateComparator = new Comparator<>(){
        @Override
            public int compare(SMS s1,SMS s2){
            return s1.getDate().compareTo(s2.getDate());
        }
    };





}
package it.unisa.SMS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SMSOrganizer {

    private List<SMS> smsOrganizer;

    public SMSOrganizer()
    {
        smsOrganizer = new ArrayList<>();
    }

    public void addSMSToOrganizer(SMS s)
    {
        smsOrganizer.add(s);
    }

    public List<SMS> getListByDate()
    {
        smsOrganizer.sort(new Comparator<SMS>() {
            @Override
            public int compare(SMS sms, SMS t1) {
                return sms.getDate().compareTo(t1.getDate());
            }
        });
        return smsOrganizer;
    }
    public List<SMS> getListBySender()
    {
        smsOrganizer.sort(new Comparator<SMS>() {
            @Override
            public int compare(SMS sms, SMS t1) {
                return sms.getSender().compareTo(t1.getSender());
            }
        });
        return smsOrganizer;
    }
}

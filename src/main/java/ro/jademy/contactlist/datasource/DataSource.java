package ro.jademy.contactlist.datasource;

import ro.jademy.contactlist.enums.ServiceProvider;
import ro.jademy.contactlist.model.Contact;
import ro.jademy.contactlist.model.PhoneNumber;

import java.util.Map;
import java.util.TreeMap;

public class DataSource {

    public static Map<PhoneNumber, Contact> contactList() {
        Map<PhoneNumber, Contact> contactList = new TreeMap<>();

        contactList.put(new PhoneNumber("0730262484", "0040", ServiceProvider.VODAFONE), new Contact(1, "Andrei", "Andreescu", new PhoneNumber("0730262484", "0040", ServiceProvider.VODAFONE), "1995-11-04", false));
        contactList.put(new PhoneNumber("0723125789", "0040", ServiceProvider.VODAFONE), new Contact(2, "Andrei", "Marinescu", new PhoneNumber("0723125789", "0040", ServiceProvider.VODAFONE), "1990-08-15", false));
        contactList.put(new PhoneNumber("0726987987", "0040", ServiceProvider.VODAFONE), new Contact(3, "Catalina", "Davidescu", new PhoneNumber("0726987987", "0040", ServiceProvider.VODAFONE), "2003-03-21", false));
        contactList.put(new PhoneNumber("0766123123", "0040", ServiceProvider.ORANGE), new Contact(4, "Maria", "Marinescu", new PhoneNumber("0766123123", "0040", ServiceProvider.ORANGE), "2002-06-21", false));
        contactList.put(new PhoneNumber("0778346656", "0040", ServiceProvider.ORANGE), new Contact(5, "Daniel", "Popescu", new PhoneNumber("0778346656", "0040", ServiceProvider.ORANGE), "1995-09-09", false));
        contactList.put(new PhoneNumber("0726321123", "0040", ServiceProvider.VODAFONE), new Contact(6, "Carina", "Popescu", new PhoneNumber("0726321123", "0040", ServiceProvider.VODAFONE), "1999-12-07", false));
        contactList.put(new PhoneNumber("0722200200", "0040", ServiceProvider.VODAFONE), new Contact(7, "Ion", "Ionescu", new PhoneNumber("0722200200", "0040", ServiceProvider.VODAFONE), "1992-01-15", false));
        contactList.put(new PhoneNumber("0763646666", "0040", ServiceProvider.TELEKOM), new Contact(8, "Alexandru", "Alexandrescu", new PhoneNumber("0763646666", "0040", ServiceProvider.TELEKOM), "1987-07-28", false));
        contactList.put(new PhoneNumber("0730303145", "0040", ServiceProvider.VODAFONE), new Contact(9, "Horia", "Munteanu", new PhoneNumber("0730303145", "0040", ServiceProvider.VODAFONE), "2000-05-01", false));
        contactList.put(new PhoneNumber("0730369874", "0040", ServiceProvider.VODAFONE), new Contact(10, "Radu", "Raducu", new PhoneNumber("0730369874", "0040", ServiceProvider.VODAFONE), "2000-11-14", false));

        return contactList;
    }

}

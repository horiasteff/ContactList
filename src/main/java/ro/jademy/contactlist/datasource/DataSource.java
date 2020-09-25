package ro.jademy.contactlist.datasource;

import com.github.javafaker.Faker;
import ro.jademy.contactlist.enums.ServiceProvider;
import ro.jademy.contactlist.model.Contact;
import ro.jademy.contactlist.model.PhoneNumber;

import java.util.Set;
import java.util.TreeSet;

public class DataSource {

    public static Set<Contact> contactList() {
        Set<Contact> contactList = new TreeSet<>();

        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            contactList.add(new Contact(faker.name().firstName(), faker.name().lastName(),
                    new PhoneNumber(faker.phoneNumber().cellPhone(), faker.country().countryCode2(), ServiceProvider.VODAFONE),
                    "2000-05-05"));
        }
        return contactList;
    }
}



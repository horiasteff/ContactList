package ro.jademy.contactlist.service;

import ro.jademy.contactlist.datasource.DataSource;
import ro.jademy.contactlist.model.Contact;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {


    @Override
    public void getContacts() {
        
    }

    @Override
    public void addContact(Contact contact) {

    }

    @Override
    public void removeContact(Contact contact) {

    }

    @Override
    public <V> Set<Contact> search(V v, Set<Contact> contacts) {
        if (v instanceof String) {
            return contacts
                    .stream()
                    .filter(f -> f.getFirstName().contains(v.toString()) ||
                            f.getLastName().contains(v.toString()) ||
                            f.getPhoneNumber().getPhoneNumber().contains(v.toString()) ||
                            f.getPhoneNumber().getCountryCode().contains(v.toString()) ||
                            f.getPhoneNumber().getServiceProvider().toString().equals(v.toString()) ||
                            f.getBirthday().toString().contains(v.toString()))
                    .collect(Collectors.toSet());
        }
        return null;
    }
}

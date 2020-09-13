package ro.jademy.contactlist.service;

import ro.jademy.contactlist.model.Contact;
import java.util.Set;

public interface UserService {

    void getContacts();

    void addContact (Contact contact);

    void removeContact (Contact contact);

    <V> Set<Contact> search(V v, Set<Contact> contacts);

}

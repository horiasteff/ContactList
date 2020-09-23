package ro.jademy.contactlist.service;

import ro.jademy.contactlist.model.Contact;
import java.util.Set;

public interface UserService {

    void getContacts(Set<Contact> contactList);

    void getFavoriteContacts(Set<Contact> contactList);

    void addContact (Contact contact, Set<Contact> contactList);

    void removeContact (Contact contact, Set<Contact> contactList);

    void editContact(Contact contact);

    Contact searchContactByFirstName (Set<Contact> tempContacts);

    <V> Set<Contact> search(V v, Set<Contact> contacts);

}

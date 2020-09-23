package ro.jademy.contactlist.service;

import ro.jademy.contactlist.datasource.DataSource;
import ro.jademy.contactlist.enums.Group;
import ro.jademy.contactlist.enums.ServiceProvider;
import ro.jademy.contactlist.model.Contact;
import ro.jademy.contactlist.model.PhoneBook;
import ro.jademy.contactlist.model.PhoneNumber;
import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private Contact searchContact;

    Scanner sc = new Scanner(System.in);

    @Override
    public void getContacts(Set<Contact> contactList) {
        contactList.forEach(System.out::println);

/*        Iterator value = contactList.iterator();
        while (value.hasNext()) {
            System.out.println(value.next());
        }*/
    }

    @Override
    public void getFavoriteContacts(Set<Contact> contactList) {
        contactList.stream().filter(e -> e.isFavorite()).forEach(System.out::println);
    }

    @Override
    public void addContact(Contact contact, Set<Contact> contactList) {
        boolean favorite;
        System.out.println("What is the first name?");
        String firstName = sc.next();
        System.out.println("What is the last name?");
        String lastName = sc.next();
        System.out.println("What is the number?");
        String number = sc.next();
        System.out.println("What is the country code?");
        String code = sc.next();
        System.out.println("What service provider is your contact?");
        String provider = sc.next();
        System.out.println("What is his/her birthday?");
        String birthday = sc.next();
        System.out.println("Is it a favorite contact/ [true/false]");
        String isFavorite = sc.next();
        favorite = isFavorite.equalsIgnoreCase("true");

        contactList.add(new Contact(firstName, lastName, new PhoneNumber(number, code, ServiceProvider.valueOf(provider.toUpperCase())), birthday, favorite));

    }

    @Override
    public void removeContact(Contact contact, Set<Contact> contactList) {
        contactList.remove(contact);
    }

    @Override
    public void editContact(Contact contact) {
        try {
            String userInput = sc.next();

            switch (userInput) {

                case "1":
                    // first name
                    System.out.println("Please enter the new contact's first name");
                    String firstName = sc.next();
                    contact.setFirstName(firstName);
                    System.out.println("Contact updated to: " + contact.getFirstName() + " " + contact.getLastName());
                    break;
                case "2":
                    //last name
                    System.out.println("Please enter the new contact's last name");
                    String lastName = sc.next();
                    contact.setLastName(lastName);
                    System.out.println("Contact updated to: " + contact.getFirstName() + " " + contact.getLastName());
                    break;

                case "3":
                    // phone number
                    System.out.println("Please enter the new contact's phone number");
                    String phoneNumber = sc.next();
                    contact.getPhoneNumber().setPhoneNumber(phoneNumber);
                    System.out.println("Contact updated to: " + contact.getFirstName() + " " + contact.getPhoneNumber());
                    break;

                case "4":
                    // group
                    System.out.println("Please enter the new contact's group number");
                    String groupName = sc.next();
                    if (groupName.equalsIgnoreCase(Group.FAVORITE.getGroupName())) {
                        contact.setGroup(Group.FAVORITE);
                    } else if (groupName.equalsIgnoreCase(Group.FAMILY.getGroupName())) {
                        contact.setGroup(Group.FAMILY);
                    } else if (groupName.equalsIgnoreCase(Group.FRIENDS.getGroupName())) {
                        contact.setGroup(Group.FRIENDS);
                    } else if (groupName.equalsIgnoreCase(Group.WORK.getGroupName())) {
                        contact.setGroup(Group.WORK);
                    } else {
                        System.out.println("This group doesn't exist!");
                    }
                    System.out.println("Contact's group successfully edited");
                    break;

                default:
                    System.out.println("Invalid input");
                    PhoneBook.showMainMenu();
                    editContact(contact);
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Invalid input. Please, choose between [1-9] only!");
            sc = new Scanner(System.in);
            PhoneBook.showMainMenu();
            editContact(contact);
        }

    }

    @Override
    public Contact searchContactByFirstName(Set<Contact> tempContacts) {
        System.out.println();
        String inputFirstName = sc.next().toLowerCase();
        Optional<Contact> contactOptional = tempContacts.stream()
                .filter(contact -> contact.getFirstName().equalsIgnoreCase(inputFirstName)).findAny();
        if (contactOptional.isPresent()) {
            searchContact = contactOptional.get();
            displayContactInfo();
        } else {
            System.out.println("\nContact not found!");
        }

        return searchContact;
    }

    private void displayContactInfo() {
        System.out.println("Contact selected:");
        System.out.println("\nContact: " + searchContact.getFirstName() + " " + searchContact.getLastName() + searchContact.getPhoneNumber());
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

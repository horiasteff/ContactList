package ro.jademy.contactlist.service;

import ro.jademy.contactlist.datasource.DataSource;
import ro.jademy.contactlist.enums.Group;
import ro.jademy.contactlist.enums.ServiceProvider;
import ro.jademy.contactlist.model.Contact;
import ro.jademy.contactlist.model.PhoneNumber;

import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private Contact searchContact;

    Scanner sc = new Scanner(System.in);
    Set<Contact> contactList = DataSource.contactList();

    @Override
    public void getContacts() {
        contactList.forEach(System.out::println);

/*        Iterator value = contactList.iterator();
        while (value.hasNext()) {
            System.out.println(value.next());
        }*/

    }

    @Override
    public void getFavoriteContacts() {
        contactList.stream().filter(e -> e.isFavorite()).forEach(System.out::println);
    }

    @Override
    public void addContact(Contact contact) {
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
    public void removeContact(Contact contact) {

    }

    @Override
    public void editContact(Contact contact) {
        String userChoice = "";
        boolean isValidInput = false;
        do {
            System.out.println();
            System.out.println("What would you like to edit?");
            System.out.println("1. First Name");
            System.out.println("2. Last Name");
            System.out.println("3. Phone Number");
            System.out.println("4. Contact Group");
            System.out.println("B. To Return to Main Menu");

            userChoice = sc.nextLine();

            switch (userChoice) {

                case "1":
                    //first name
                    boolean isValidFirstName = false;
                    do {
                        System.out.println("Please enter the new contact's first name");
                        String firstName = sc.nextLine();

                        if (firstName.length() > 0) {
                            contact.setFirstName(firstName);
                            isValidFirstName = true;
                        }
                    } while (!isValidFirstName);
                    System.out.println("First name successfully edited");
                    break;

                case "2":
                    //last name
                    System.out.println("Please enter the new contact's last name");
                    String lastName = sc.nextLine();
                    contact.setLastName(lastName);
                    System.out.println("Last name successfully edited");
                    break;

                case "3":
                    // phone number
                    System.out.println("Please enter the new contact's phone number");
                    String phoneNumber = sc.nextLine();
                    contact.getPhoneNumber().setPhoneNumber(phoneNumber);
                    System.out.println("Phone number successfully edited");
                    break;

                case "4":
                    // group
                    System.out.println("Please enter the new contact's group number");
                    String groupName = sc.nextLine();
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


                case "n":
                    isValidInput = true;
                    break;

                default:
                    System.out.println("Invalid input");
            }
        }
        while (!isValidInput);

    }

    @Override
    public void searchContactByFirstName(Set<Contact> tempContacts) {
        System.out.println();
        String inputFirstName = sc.next();
        Optional<Contact> contactOptional = tempContacts.stream()
                .filter(contact -> contact.getFirstName().equalsIgnoreCase(inputFirstName)).findAny();
        if (contactOptional.isPresent()) {
            searchContact = contactOptional.get();
        } else {
            System.out.println("\nContact not found!");
        }
    }

/*    private void displayContactInfo() {
        System.out.println("Contact selected:");
        System.out.println("\nContact: " + searchContact.getFirstName() + " " + searchContact.getLastName() + searchContact.getPhoneNumber());
    }*/

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

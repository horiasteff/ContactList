package ro.jademy.contactlist.service;

import ro.jademy.contactlist.datasource.DataSource;
import ro.jademy.contactlist.enums.ServiceProvider;
import ro.jademy.contactlist.model.Contact;
import ro.jademy.contactlist.model.PhoneNumber;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    Scanner sc = new Scanner(System.in);
    Set<Contact> contactList = DataSource.contactList();

    @Override
    public void getContacts() {
        contactList.forEach(System.out::println);
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
    public void editContact() {
        getContacts();
        System.out.println("Please choose the contact you want to edit: ");
        String choice = sc.next();
        System.out.println("The contact that you chose to edit is: ");
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

    private void modifyContactDetails(Contact modifiedContact){
        System.out.println("Please enter the fields you want to change:");
        System.out.println("1.First name");
        System.out.println("2.Last name");
        System.out.println("3.Phone number");
        System.out.println("4.Birthday");
        int choice = sc.nextInt();
        String modifiedVal;
        switch (choice){
            case 1:
                System.out.println("Please enter new First Name: ");
                modifiedVal = sc.next();
                modifiedContact.setFirstName(modifiedVal);
                System.out.println("The new First Name that you have chosen is: " + modifiedVal);
                break;
            case 2:
                System.out.println("Please enter new Last Name: ");
                modifiedVal = sc.next();
                modifiedContact.setLastName(modifiedVal);
                System.out.println("The new Last Name that you have chosen is: " + modifiedVal);
                break;
            case 3:
              /*  System.out.println("Please enter new Phone Number: ");
                modifiedVal = sc.next();
                modifiedContact.setPhoneNumber(modifiedContact.phoneNumber.setPhoneNumber(modifiedVal));;
                System.out.println("The new Phone Number that you have chosen is: " + modifiedVal);
                */
                break;
            case 4:
               /* System.out.println("Please enter new Birthday: ");
                modifiedVal = sc.next();
                modifiedContact.setBirthday(modifiedContact);
                System.out.println("The new Birthday that you have chosen is: " + modifiedVal);
                */
                break;
        }
    }
}

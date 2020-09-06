package ro.jademy.contactlist.model;

import ro.jademy.contactlist.datasource.DataSource;
import ro.jademy.contactlist.enums.ServiceProvider;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhoneBook {

    Scanner sc = new Scanner(System.in);
    Map<PhoneNumber, Contact> contactList = DataSource.contactList();

    public void printMenu() {

        System.out.println("Welcome!");
        System.out.println("1. List contacts"); // -> manage contacts
        System.out.println("2. List favorites");
        System.out.println("3. Search contact"); //TODO: search..submenu
        System.out.println("4. Add contact");
        System.out.println("5. Exit ");

        String choice = sc.next();
        PhoneBook phoneBook = new PhoneBook();
        switch (choice) {
            case "1":
                //LIST ALL CONTACTS
                phoneBook.showContacts();
                break;
            case "2":
                //LIST FAVORITE
                phoneBook.showFavorites();
                break;
            case "3":
                //SEARCH CONTACT -> SUBMENU
                break;
            case "4":
                //ADD CONTACT
                phoneBook.addContact();
                break;
            case "5":
                System.exit(0);
                break;
        }
    }
    //TODO: MENU

    private void printSubmenu() {

        System.out.println("1. Search bt first name"); //prenume
        System.out.println("2. Search bt last name");  //nume de familie
        System.out.println("3. Search by phone number");
    }

    private void showContacts() {
        Set<Map.Entry<PhoneNumber, Contact>> entries = contactList.entrySet();
        entries.forEach(System.out::println);
    }

    private void showFavorites() {
        Set<Map.Entry<PhoneNumber, Contact>> entries = contactList.entrySet();
        entries.stream().filter(e -> e.getValue().isFavorite()).forEach(System.out::println);
    }

    private void addContact() {
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

        Map<PhoneNumber, Contact> contactList = DataSource.contactList();
        contactList.put(new PhoneNumber(number, code, ServiceProvider.valueOf(provider.toUpperCase())), new Contact(11, firstName, lastName, new PhoneNumber(number, code, ServiceProvider.valueOf(provider.toUpperCase())), birthday, favorite));
    }
}


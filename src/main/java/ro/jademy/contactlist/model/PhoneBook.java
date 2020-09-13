package ro.jademy.contactlist.model;

import ro.jademy.contactlist.datasource.DataSource;
import ro.jademy.contactlist.enums.ServiceProvider;
import ro.jademy.contactlist.service.UserServiceImpl;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {

    Scanner sc = new Scanner(System.in);
    Set<Contact> contactList = DataSource.contactList();
    Set<Contact> filteredContacts = new TreeSet<>();
    UserServiceImpl userService = new UserServiceImpl();


    public void printMenu() {

        System.out.println("1. List contacts"); // -> manage contacts
        System.out.println("2. List favorites");
        System.out.println("3. Search contact"); //TODO: search..submenu
        System.out.println("4. Add contact");
        System.out.println("5. Exit ");
        System.out.println();


        String choice = sc.next();
        PhoneBook phoneBook = new PhoneBook();
        switch (choice) {
            case "1":
                //LIST ALL CONTACTS
                userService.getContacts();
                break;
            case "2":
                //LIST FAVORITE
                userService.getFavoriteContacts();
                break;
            case "3":
                //SEARCH CONTACT -> SUBMENU
                userService.getContacts();
                System.out.println("Search :");
                filteredContacts= userService.search(sc.next(),contactList);
                filteredContacts.forEach(contact -> System.out.println(contact));
                break;
            case "4":
                //TODO: ADD CONTACT
                //ADD CONTACT
               // userService.addContact();
                break;
            case "5":
                System.exit(0);
                break;
        }
    }

    //TODO: SUBMENU
    private void printSubmenu() {
        System.out.println("1. Search by first name"); //prenume
        System.out.println("2. Search by last name");  //nume de familie
        System.out.println("3. Search by phone number");
    }
}


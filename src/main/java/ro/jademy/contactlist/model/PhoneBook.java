package ro.jademy.contactlist.model;

import ro.jademy.contactlist.datasource.DataSource;
import ro.jademy.contactlist.enums.ServiceProvider;
import ro.jademy.contactlist.service.UserServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {

    Scanner sc = new Scanner(System.in);
    Set<Contact> contactList = DataSource.contactList();
    Set<Contact> filteredContacts = new TreeSet<>();
    UserServiceImpl userService = new UserServiceImpl();


    public void initiateMenu() {
        showMainMenu();

        try {
            String choice = sc.next();

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
                    showSearchSubMenu();
                    filteredContacts = userService.search(sc.next(), contactList);
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
        } catch (InputMismatchException e) {
            System.out.println("Invalid option!" + sc + " Please enter your option again: ");
            String choice = sc.next();
            initiateMenu();
        }
    }

    public void showMainMenu() {

        System.out.println("============================");
        System.out.println("|       CONTACTLIST        |");
        System.out.println("============================");
        System.out.println("|    1. List contacts      |"); // -> manage contacts
        System.out.println("|    2. List favorites     |");
        System.out.println("|    3. Search contact     |"); //TODO: search..submenu
        System.out.println("|    4. Add contact        |");
        System.out.println("|    5. Exit               |");
        System.out.println();
    }

    private void showSearchSubMenu() {
        System.out.println("================================");
        System.out.println("|           SEARCH             |");
        System.out.println("================================");
        System.out.println("|  1. Search by first name     |");
        System.out.println("|  2. Search by last name      |");
        System.out.println("|  3. Search by phone number   |");
        System.out.println("|  4. Return to previous menu  |");

    }

    private void showEditSubMenu() {
        System.out.println("================================");
        System.out.println("|           Edit Contact       |");
        System.out.println("================================");
        System.out.println("|  1. Edit Contact info        |");
        System.out.println("|  2. Delete Contact           |");
        System.out.println("|  4. Return to previous menu  |");

    }

/*    private void searchContact() {
        try {
            System.out.println("Enter an option:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: // Search by first name
                    break;
                case 2: // Search by last name
                    break;
                case 3: // Search by phone number
                    break;
                case 4: // Return to previous menu
                    break;
                default: // For invalid inputs
                    System.out.println("Invalid input!" + sc + "Please choose either 1,2,3 or 4");
                    showSearchSubmenu();
                    searchContact();
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input!" + sc + "Please choose either 1,2,3 or 4");
            String choice = sc.next();
            showSearchSubmenu();
            searchContact();
        }
    }*/
}


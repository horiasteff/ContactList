package ro.jademy.contactlist.model;

import org.apache.commons.lang3.StringUtils;
import ro.jademy.contactlist.datasource.DataSource;
import ro.jademy.contactlist.enums.ServiceProvider;
import ro.jademy.contactlist.service.UserServiceImpl;
import java.util.*;

public class PhoneBook {

    Scanner sc = new Scanner(System.in);
    Set<Contact> contactList = DataSource.contactList();
    Set<Contact> filteredContacts = new TreeSet<>();
    UserServiceImpl userService = new UserServiceImpl();
    Contact extractedContact;

    public void initiateMenu() {
        do {
            showMainMenu();
            try {
                String choice = sc.next();

                switch (choice) {
                    case "1":
                        //LIST ALL CONTACTS + EDIT CONTACT SUB-MENU

                        showHeader();
                        userService.getContacts(contactList);
                        System.out.println();
                        System.out.println("Press 'E' if you want to edit a contact.");
                        System.out.println("Press 'B' to go back to the main menu.");
                        String userChoice = sc.next();
                        if (userChoice.equalsIgnoreCase("e")) {
                            System.out.println("Which contact do you want to edit?");
                            System.out.println("Please type the contact's first name.");
                            extractedContact = userService.searchContactByFirstName(contactList);
                            showEditSubMenu();
                            userService.editContact(extractedContact);
                        } else if (userChoice.equalsIgnoreCase("b")) {
                        } else {
                            System.out.println("Wrong input!");
                        }
                        System.out.println();
                        break;

                    case "2":
                        //LIST FAVORITE

                        userService.getFavoriteContacts(contactList);
                        break;

                    case "3":
                        //SEARCH CONTACT -> SUBMENU

                        userService.getContacts(contactList);
                        System.out.println("Search :");
                        showSearchSubMenu();
                        filteredContacts = userService.search(sc.next(), contactList);
                        filteredContacts.forEach(contact -> System.out.println(contact));
                        break;

                    case "4":
                        //ADD CONTACT

                        // userService.addContact();
                        break;

                    case "5":
                        //REMOVE CONTACT

                        // userService.removeContact();
                        break;

                    case "6":
                        System.exit(0);
                        break;

                    default: // For invalid inputs
                        System.out.println("Invalid input. Please, choose between [1-6] only!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid option!" + sc + " Please enter your option again: ");
                String choice = sc.next();
                initiateMenu();
            }
        } while (true);
    }

    public static void showMainMenu() {

        System.out.println("============================");
        System.out.println("|       CONTACT LIST       |");
        System.out.println("============================");
        System.out.println("|    1. List contacts      |"); // -> sub-menu for managing contacts
        System.out.println("|    2. List favorites     |");
        System.out.println("|    3. Search contact     |");
        System.out.println("|    4. Add contact        |");
        System.out.println("|    5. Remove contact     |");
        System.out.println("|    6. Exit               |");
        System.out.println();
    }


    private static void showSearchSubMenu() {
        System.out.println("================================");
        System.out.println("|           SEARCH             |");
        System.out.println("================================");
        System.out.println("|  1. Search by first name     |");
        System.out.println("|  2. Search by last name      |");
        System.out.println("|  3. Search by phone number   |");
        System.out.println("|  4. Return to previous menu  |");

    }

    private static void showEditSubMenu() {
        System.out.println("================================");
        System.out.println("           Edit Contact         ");
        System.out.println("================================");
        System.out.println("|  1. Edit contact's first name   |");
        System.out.println("|  2. Edit contact's last name    |");
        System.out.println("|  3. Edit contact's phone number |");
        System.out.println("|  4. Return to previous menu     |");

    }

    private void showHeader() {
        System.out.println(StringUtils.center("  FIRST NAME", 15, " ") +
                StringUtils.center("  LAST NAME", 15, " ") +
                StringUtils.center(" PHONE NUMBER", 30, " ") +
                StringUtils.center("  COUNTRY CODE", 10, " ") +
                StringUtils.center("  SERVICE", 5, " ") +
                StringUtils.center("  BIRTHDATE", 15, " ") +
                StringUtils.center("  IS_FAVORITE", 10," "));
    }

    private void showHeader() {
        System.out.println(StringUtils.center("  FIRST NAME", 15, " ") +
                StringUtils.center("  LAST NAME", 15, " ") +
                StringUtils.center(" PHONE NUMBER", 30, " ") +
                StringUtils.center("  COUNTRY CODE", 10, " ") +
                StringUtils.center("  SERVICE", 5, " ") +
                StringUtils.center("  BIRTHDATE", 15, " ") +
                StringUtils.center("  IS_FAVORITE", 10," "));
    }
}
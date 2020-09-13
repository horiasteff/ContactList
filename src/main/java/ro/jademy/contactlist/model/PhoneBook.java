package ro.jademy.contactlist.model;

import ro.jademy.contactlist.datasource.DataSource;
import ro.jademy.contactlist.enums.ServiceProvider;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class PhoneBook {
    PhoneBook phoneBook = new PhoneBook();
    Scanner sc = new Scanner(System.in);
    Set<Contact> contactList = DataSource.contactList();


    private void initiateMenu() {
        showMainMenu();
        try {
            String choice = sc.next();
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
                    //TODO: SEARCH METHODS
                    //SEARCH CONTACT -> SUBMENU
                    showSearchSubmenu();
                    break;
                case "4":
                    //TODO: ADD CONTACT
                    //ADD CONTACT
                    phoneBook.addContact();
                    break;
                case "5":
                    System.exit(0);
                    break;
            }
        }catch (InputMismatchException e){
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
    }


    //TODO: SUBMENU
    private void showSearchSubmenu() {
        System.out.println("================================");
        System.out.println("|           SEARCH             |");
        System.out.println("================================");
        System.out.println("|  1. Search by first name     |");
        System.out.println("|  2. Search by last name      |");
        System.out.println("|  3. Search by phone number   |");
        System.out.println("|  4. Return to previous menu  |");

    }

    private void showContactSubmenu() {
        System.out.println("================================");
        System.out.println("|           Edit Contact       |");
        System.out.println("================================");
        System.out.println("|  1. Edit Contact info        |");
        System.out.println("|  2. Delete Contact           |");
        System.out.println("|  4. Return to previous menu  |");

    }


    private void showContacts() {
        Set<Contact> contactList = DataSource.contactList();
        contactList.forEach(System.out::println);
    }

    private void showFavorites() {
        Set<Contact> contactList = DataSource.contactList();
        contactList.stream().filter(e -> e.isFavorite).forEach(System.out::println);
    }

    private void addContact() {
        //TODO: Add contact method ?!...
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
        showContacts();
    }

    private void searchContact() {
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
    }


    private void editContact(){
        showContacts();
        System.out.println("Please choose the contact you want to edit: ");
        String choice = sc.next();
        System.out.println("The contact that you chose to edit is: ");
        /*Contact modifiedContact = contactList.stream().filter(contact -> contact.)
        *
        * HOW TO:
        * choose a contact so we can edit the options*/
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
                break;
                TODO ... HELP?!
                */
            case 4:
               /* System.out.println("Please enter new Birthday: ");
                modifiedVal = sc.next();
                modifiedContact.setBirthday(modifiedContact);
                System.out.println("The new Birthday that you have chosen is: " + modifiedVal);
                break;*/

                //TODO ... HELP?!
        }
    }


}


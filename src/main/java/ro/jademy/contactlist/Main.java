package ro.jademy.contactlist;

import ro.jademy.contactlist.model.PhoneBook;
import ro.jademy.contactlist.service.ValidateInputImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //TODO: STYLE THE WAY WE LIST CONTACTS

        // Search...
        // A
        // 1. Andrei Andreescu 0730456465
        //  1.1 Call
        //  1.2 Message
        //  1.3 Edit contact
        // 2. Andrei Andreescu 0730456465

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.initiateMenu();

    }
}
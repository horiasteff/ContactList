package ro.jademy.contactlist.model;

import org.apache.commons.lang3.StringUtils;
import ro.jademy.contactlist.enums.Group;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Contact implements Comparable<Contact> {

    protected String firstName;
    protected String lastName;
    protected Group group;
    protected PhoneNumber phoneNumber;
    protected LocalDate birthday;
    protected boolean isFavorite;

    public Contact(String firstName, String lastName, PhoneNumber phoneNumbers, String birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumbers;
        this.birthday = LocalDate.parse(birthday);
    }
    public Contact(String firstName, String lastName, PhoneNumber phoneNumbers, String birthday,boolean isFavorite) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumbers;
        this.birthday = LocalDate.parse(birthday);
        this.isFavorite = isFavorite;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Group getGroup() { return group; }

    public void setGroup(Group group) { this.group = group; }

    public PhoneNumber getPhoneNumbers() {
        return phoneNumber;
    }

    public void setPhoneNumbers(PhoneNumber phoneNumbers) {
        this.phoneNumber = phoneNumbers;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return isFavorite == contact.isFavorite &&
                Objects.equals(firstName, contact.firstName) &&
                Objects.equals(lastName, contact.lastName) &&
                Objects.equals(phoneNumber, contact.phoneNumber) &&
                Objects.equals(birthday, contact.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, birthday, isFavorite);
    }

    @Override
    public String toString() {
        return
                StringUtils.center(firstName, 17, " ") +
                        StringUtils.center(lastName, 17, " ") +
                        StringUtils.center(String.valueOf(phoneNumber), 50, " ") +
                        StringUtils.center(String.valueOf(birthday), 15, " ") +
                        StringUtils.center(String.valueOf(isFavorite), 10, " ");
    }

    @Override
    public int compareTo(Contact o) {
        return Comparator.comparing(Contact::getLastName)
                .thenComparing(Contact::getFirstName)
                .thenComparing(Contact::getPhoneNumber).compare(this, o);
    }
}
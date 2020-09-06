package ro.jademy.contactlist.model;

import java.time.LocalDate;
import java.util.Objects;

public class Contact {

    protected Integer index;
    protected String firstName;
    protected String lastName;
    protected PhoneNumber phoneNumber;
    protected LocalDate birthday;
    protected boolean isFavorite;

    public Contact(Integer index, String firstName, String lastName, PhoneNumber phoneNumbers, String birthday, boolean isFavorite) {
        this.index = index;
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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
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
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumbers=" + phoneNumber +
                ", birthday=" + birthday +
                ", isFavorite=" + isFavorite +
                '}';
    }
}

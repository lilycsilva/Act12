import java.util.HashMap;

/**
 * Models a Contact with a first name, last name, phone number, email address,
 * and any variable number of custom fields.
 */

public class Contact {
    String firstName, lastName, phoneNumber, toString;

    /**
     * Default constructor used for testing. This must be inserted here since we
     * have a custom constructor and java no longer creates a default
     * constructor when you have a custom constructor. You must initialize your
     * objects here.
     */

    public Contact() {
        firstName = lastName = phoneNumber = toString = null;
    }

    /**
     * Custom constructor that builds a contact with the specified values. Does
     * not include custom fields. You must initialize your objects here.
     *
     * @param firstName
     *            the first name of the contact
     * @param lastName
     *            the last name of the contact
     * @param phoneNumber
     *            the phone number of the contact
     */
    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for the first name of this contact. Allows the AddressBook
     * developer to get the value of the first name of a contact.
     *
     * @return the first name of the contact as a string
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for the first name of this contact. Allows the AddressBook
     * developer to set the value of the first name of a contact.
     *
     * @param firstName
     *            the first name as a string to set to
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    /**
     * Getter for the last name of this contact. Allows the AddressBook
     * developer to get the value of the last name of a contact.
     *
     * @return the last name of the contact as a string
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the last name of this contact. Allows the AddressBook
     * developer to set the value of the last name of a contact.
     *
     * @param lastName
     *            the last name as a string to set to
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the phone number of this contact. Allows the AddressBook
     * developer to get the value of the phone number of a contact.
     *
     * @return the phone number of the contact as a string
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for the phone number of this contact. Allows the AddressBook
     * developer to set the value of the phone number of a contact.
     *
     * @param phoneNumber
     *            the phone number as a string to set to
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Provides a string representation of a contact. Use your string parsing
     * knowledge to make the string look like what's required by the contact
     * tests.
     *
     * @return a string representation of a contact
     */
    public String toString() {

        toString = "First Name: " + firstName + "\nLast Name: " + lastName
                + "\nPhone Number: " + phoneNumber;
            return toString;
        }

    }

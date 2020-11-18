import java.util.ArrayList;

/**
 * A model of an address book which keeps track of contacts. An address book
 * object should keep track of the concept of a current contact (think index).
 * You must use an ArrayList for your implementation.
 */

public class AddressBook {
    Contact contact = new Contact();

    /**
     * Default constructor for an address book. You should initialize your
     * objects here.
     */
    public AddressBook() {
        currentContactIndex = null;
    }

    /**
     * Add a contact by passing in a constructed contact object filled with
     * data. The current contact should be updated to refer to the index of the
     * newly added contact.
     *
     * @param contact
     *            the contact object to add to the address book.
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
        currentContactIndex = contacts.size() - 1;

    }

    // Temporary printout
    public void printItems() {
        for (Contact contact : contacts)
            System.out.println("*** = " + contact);
    }

    /**
     * Remove a contact by deleting what ever index the current contact refers
     * to. The current contact index should be updated to point at the next
     * contact in the list.
     */
    public void deleteContact() {
        if (contacts.size() == 0)
            return;
        contacts.remove(currentContactIndex.intValue());
        if (currentContactIndex == contacts.size()) {
            currentContactIndex = currentContactIndex - 1;
        }
        if(contacts.size()==0)
            currentContactIndex = null;
    }

    /**
     * Update the current contact index to refer to the next contact in the
     * list. If you are at the last item in the list then you should update the
     * current contact index to point at the first contact in the list.
     */
    public void next() {
        if (contacts.size() == 0)
            return;
        currentContactIndex = currentContactIndex + 1;
        if (currentContactIndex == contacts.size())
            currentContactIndex = 0;
    }

    /**
     * Update the current contact index to refer to the next contact in the
     * list. If you are at the first item in the list then you should update the
     * current contact index to point at the last contact in the list.
     */
    public void previous() {
        if (contacts.size() == 0)
            return;
        else
            currentContactIndex = currentContactIndex - 1;
        if (currentContactIndex == -1)
            currentContactIndex = contacts.size() - 1;

    }

    /**
     * Check if the address book has any contacts in it or not.
     *
     * @return true if there are no contacts in the address book, otherwise
     *         false
     */
    public Boolean isEmpty() {
        boolean isEmpty = contacts.isEmpty();
        return isEmpty;
    }

    /**
     * Update a single field of the current contact. This can also be used to
     * update a contact with a new custom field.
     *
     * @param fieldName
     *            the name of the field to update
     * @param fieldValue
     *            the value of the field to update to
     * @throws Exception
     */
    public void updateContact(String fieldName, String fieldValue) {
        if (contacts.size() == 0)
            return;
        switch (fieldName.toLowerCase()) {
            case "firstname":
            case "first name":
                getCurrentContact().setFirstName(fieldValue);
                break;
            case "lastname":
            case "last name":
                getCurrentContact().setLastName(fieldValue);
                break;
            case "phonenumber":
            case "phone number":
                getCurrentContact().setPhoneNumber(fieldValue);
                break;
        }
    }

    /**
     * Get the current number of contacts in the address book.
     *
     * @return the count as an integer of the number of contacts in the address
     *         book
     */
    public Integer getContactCount() {
        if (contacts == null) {
            contactCount = 0;
        } else
            contactCount = contacts.size();
        return contactCount;
    }

    /**
     * Get the contact object that the current contact index refers to
     *
     * @return the current contact object
     */
    public Contact getCurrentContact() {
        if (currentContactIndex != null)
            return contacts.get(currentContactIndex);
        else
            return null;
    }

    /**
     * Search for a string value within a contact. If the provided value exists
     * anywhere within a contact, it should be considered a match. If multiple
     * contacts are found to have a match then both should be returned.
     *
     * @param valueToSearchFor
     *            the string value to search for in a contact
     * @return a list of contacts that contain the string value provided
     */
    public ArrayList<Contact> searchForContact(String valueToSearchFor) {
        searchHits.clear();
        for (Contact value : contacts)
            if (value.toString().toLowerCase().contains(valueToSearchFor.toLowerCase()))
                searchHits.add(value);
        return searchHits;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public Integer getCurrentContactIndex() {
        return currentContactIndex;
    }

    public void setCurrentContactIndex(Integer currentContactIndex) {
        this.currentContactIndex = currentContactIndex;
    }

    private int contactCount;
    private ArrayList<Contact> searchHits = new ArrayList<Contact>();
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private Integer currentContactIndex;
}

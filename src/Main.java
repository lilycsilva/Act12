import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Initiation of variables
        Menu menuSystem = new Menu();
        AddressBook addressBook = new AddressBook();
        Scanner in = new Scanner(System.in);
        Contact contact = new Contact();
        Boolean quit = false;
        boolean customFieldBoolean = false;
        String repeat;
        String yesOrNo = "n";
        boolean validInput;
        ;
        String crudeMenuChoice = null;

        // The main loop that will loop until the application closes
        do {

            // Displays the main menu system
            repeat = null;
            menuSystem.displayMainMenu();

            // Displays contact if there is a current one, else alerts.
            if (addressBook.getCurrentContact() != null) {
                System.out.println("*****Contact Actual*****");
                System.out.println(addressBook.getCurrentContact().toString());
            } else {
                System.out.println("*****No hay contactos*****");
            }

            // Asks for user to input menu # and then stores it in menuChoice variable
            System.out.println();
            System.out.print("Porfavor elige un numero del menu (1-8): ");

            validInput = false;
            // Catches invalid inputs repeats until it receives the acceptable input
            while (validInput == false) {
                validInput = true;
                crudeMenuChoice = in.nextLine();

                try {
                    int menuChoice = Integer.parseInt(crudeMenuChoice);

                } catch (Exception e) {
                    validInput = false;
                    System.out.println();
                    System.out.print("Invalido, intenta otra vez: ");

                } finally {
                    if (validInput == true) {
                        int menuChoice = Integer.parseInt(crudeMenuChoice);
                        if (1 > menuChoice || 8 < menuChoice) {
                            validInput = false;
                            System.out.println();
                            System.out.print("Numero invalido, intenta otra vez: ");
                        }
                    }

                }

            }
            // Converts the input into a legitimate integer
            int menuChoice = Integer.parseInt(crudeMenuChoice);

            // Main switch which takes user the menu number that they have selected
            switch (menuChoice) {
                case 1: // displays next contact
                    addressBook.next();

                    break;
                case 2: // displays previous contact
                    addressBook.previous();

                    break;
                case 3: // Adds a new contact
                    // Gathers default field values first
                    menuSystem.displayAddContactMenu();
                    contact = new Contact();
                    System.out.println();
                    System.out.print("Introduce el primer nombre: ");
                    String firstName = in.nextLine();
                    contact.setFirstName(firstName);
                    System.out.print("Introduce el apellido: ");
                    String lastName = in.nextLine();
                    contact.setLastName(lastName);
                    System.out.print("Introduce el telefono: ");
                    String phoneNumber = in.nextLine();
                    contact.setPhoneNumber(phoneNumber);
                    addressBook.addContact(contact);

                    break;

                case 4: // Deletes a contact
                    menuSystem.displayDeleteContactMenu();
                    yesOrNo = in.nextLine();
                    if (yesOrNo.toLowerCase().equals("y"))
                        addressBook.deleteContact();
                    break;

                case 5: // Updates a contact
                    menuSystem.displayUpdateContactMenu();
                    String crudeUpdateInfo = in.nextLine();
                    if (crudeUpdateInfo.contains(","))
                        addressBook.updateContact(crudeUpdateInfo.substring(0,
                                crudeUpdateInfo.indexOf(",")), crudeUpdateInfo
                                .substring(crudeUpdateInfo.indexOf(",") + 1,
                                        crudeUpdateInfo.length()));
                    else
                        System.out
                                .println("La info no fue escrita correctamente, porfavor usa una coma!");
                    System.out.println("Presiona [Enter] para continuar");
                    repeat = in.nextLine();
                    if (!repeat.equals(null))
                        break;
                    break;

                case 6: // Displays number of current contacts
                    menuSystem.displayNumberOfContactsMenu();
                    System.out.println(addressBook.getContactCount());
                    System.out.println();
                    System.out.println("Presiona [Enter] para continuar");
                    repeat = in.nextLine();
                    if (!repeat.equals(null))
                        break;

                case 7: // Searches for a contact and gives option to display the search results
                    menuSystem.displaySearchForContactMenu();
                    String searchInfo = in.nextLine();
                    ArrayList<Contact> matches = addressBook.searchForContact(searchInfo);
                    if (matches.size() == 0) {
                        System.out.println("No se encontraron resultados.");
                        System.out.println();
                        System.out.println("Presiona [Enter] para continuar");
                        repeat = in.nextLine();
                        if (!repeat.equals(null))
                            break;
                    } else
                        System.out.println("Hay " + matches.size() + " resultados encontrados.");
                    System.out.println("Quieres ver los resultados (Y/N)?");
                    yesOrNo = "n";
                    yesOrNo = in.nextLine();
                    if (yesOrNo.toLowerCase().equals("y")) {

                        System.out.println("**********");
                        System.out.println("Search Results:");
                        System.out.println();
                        for (Contact match : matches) {
                            System.out.println(match.toString());
                            System.out.println("----------");
                        }
                        System.out.println("**********");

                        System.out.println();
                        System.out.println("Presiona [Enter] para continuar");
                        repeat = in.nextLine();
                        if (!repeat.equals(null))
                            break;
                    } else
                        break;
                case 8: // Terminates the application
                    menuSystem.displayQuitApplicationMenu();
                    yesOrNo = in.nextLine();
                    if (yesOrNo.toLowerCase().equals("y")) {
                        System.out.println();
                        System.out.println("***** Application terminated. *****");
                        quit = true;
                    }
                    break;
                default: // Default output for invalid inputs that pass the filters above the switch
                    System.out.println();
                    System.out.println("Error!");
                    break;
            }

        } while (quit != true);

    }
}

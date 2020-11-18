public class Menu {
    //Contains static displays for both the main menu and sub menus

    public void displayMainMenu() {
        System.out.println();
        System.out.println("---------------- ADDRESS BOOK ----------------");
        System.out.println("-         1. mostrar el contacto siguiente   -");
        System.out.println("-         2. mostrar el contacto anterior    -");
        System.out.println("-         3. crear un contacto               -");
        System.out.println("-         4. borrar un contacto              -");
        System.out.println("-         5. actualizar un contacto          -");
        System.out.println("-         6. mostrar el numero de contactos  -");
        System.out.println("-         7. buscar un contacto              -");
        System.out.println("-         8. salir                           -");
        System.out.println("----------------------------------------------");
        System.out.println();
    }

    public void displayAddContactMenu() {
        System.out.println();
        System.out.println("***** CREAR CONTACTO MENU *****");
        System.out.println("Introduce la informacion del contacto.");
    }

    public void displayDeleteContactMenu() {
        System.out.println();
        System.out.println("***** BORRAR CONTACTO MENU *****");
        System.out.println("Estas seguro de borrar el contacto actual? (Y/[N]");
    }

    public void displayUpdateContactMenu() {
        System.out.println();
        System.out.println("***** ACTUALIZAR CONTACTO MENU *****");
        System.out.print("introduce el nombre del campo y el valor separarado por una coma:");
    }

    public void displayNumberOfContactsMenu() {
        System.out.println();
        System.out.println("***** NUMERO DE CONTACTOS MENU *****");
        System.out.print("Num de contactos: ");
    }

    public void displaySearchForContactMenu() {
        System.out.println();
        System.out.println("***** BUSCAR CONTACTO MENU *****");
        System.out.print("Introduce un nombre o numero a buscar: ");
    }

    public void displayQuitApplicationMenu() {
        System.out.println();
        System.out.println("***** QUIT MENU *****");
        System.out.print("Estas seguro de querer salir? (Y/[N]) : ");
    }

}
